package gb.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String nick;
    private static final Logger logger = LogManager.getLogger(Server.class.getName());

    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if(str.startsWith("/auth")) {
                            String[] tokens = str.split(" ");
                            String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                            if(newNick != null) {
                                sendMsg("/authok");
                                nick = newNick;
                                server.subscribe(this);
                                logger.info("Пользователь " + nick + " вошел в систему");
                                break;
                            } else {
                                sendMsg("Неверный логин/пароль");
                                logger.warn("Неверный пароль для пользователя " + nick);
                            }
                        }
                    }
                    while (true) {
                        String str = in.readUTF();
                        if(str.equals("/end")) {
                            logger.info("Пользователь " + nick + " вышел из системы");
                            out.writeUTF("/serverclosed");
                            break;
                        }
                        server.broadcastMsg(nick + ": " + str);
                        logger.debug("Пользователь " + nick + " прислал сообщение: " + str);
                        System.out.println("Client: " + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

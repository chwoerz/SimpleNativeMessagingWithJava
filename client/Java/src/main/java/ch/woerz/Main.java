package ch.woerz;

import org.json.JSONObject;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            byte[] size = new byte[4];
            int readBytes = System.in.read(size);
            int sizeOfMessage = getSize(size);
            byte[] msg = new byte[sizeOfMessage];
            System.in.read(msg);
            JSONObject jsonObject = new JSONObject(new String(msg, "UTF-8"));
            String text = jsonObject.getString("text");
            sendMessage(jsonObject.toString());
        }
    }

    private static int getSize(byte[] bytes) {
        return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    private static byte[] toSize(int i) {
        return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array();
    }

    private static void sendMessage(String message) throws IOException {
        System.out.write(toSize(message.length()));
        System.out.write(message.getBytes("UTF-8"));
        System.out.flush();
    }
}

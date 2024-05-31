package models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import database.DTO.PlayerDTO;
import global.GVAR;
import server.runServer;
import global.StreamDataType;

public class Player implements Runnable {

	Socket socket;
	DataInputStream inputStream;
	DataOutputStream outputStream;

	PlayerDTO playerDTO;
	Player opponentPlayer;

	boolean isMatching = false;
	String matchingStatus = "CANCEL";

	Match match = null;

	public Player(Socket socket) throws IOException {
		this.socket = socket;
		this.inputStream = new DataInputStream(socket.getInputStream());
		this.outputStream = new DataOutputStream(socket.getOutputStream());
	}

	@Override
	public void run() {
		String receivedData;
		Boolean isClientRunning = true;

		while (!runServer.isShutdown) {
			try {
				receivedData = inputStream.readUTF();
				Integer streamDataType = StreamDataType.getTypeFromData(receivedData);

				if (streamDataType == StreamDataType.LOGIN) {
					onLogin(receivedData);
				} else if (streamDataType == StreamDataType.SIGNUP) {
					onSignUp(receivedData);
				} else if (streamDataType == StreamDataType.GAME_EVENT) {
					onGameEvent(receivedData);
				} else if (streamDataType == StreamDataType.SEND_MESSAGE) {
					onSendMessage(receivedData);
					System.out.println("SERVER: RECEIVED DATA:" + receivedData);
				}

			} catch (Exception ex) {
				break;
			}
		}

		try {
			this.inputStream.close();
			this.outputStream.close();
			this.socket.close();
			runServer.playerManager.remove(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void onLogin(String receivedData) {

	}

	public void onSignUp(String receivedData) {

	}

	public void onGameEvent(String receivedData) {

	}
	
	public void onSendMessage(String receivedData) {
		String data = receivedData.split("/")[1];
		runServer.playerManager.broadcast(data);
	}
}

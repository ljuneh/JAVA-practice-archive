package com.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
	
	public Server() throws IOException {
		ServerSocket serverSocket = new ServerSocket(10000);
		System.out.println("서버: 10000 포트가 오픈");
		
		// 클라이언트에서 서버로 오는 응답 대기
		Socket socket = serverSocket.accept();
		System.out.println("서버: 클라이언트: "+socket.getInetAddress()+" 연결됨");
		System.out.println("서버: 클라이언트: "+socket.getPort()+" 연결됨");
		
		// I/O 버퍼: 데이터 저장소
		// 입력버퍼에서 읽어오는 처리
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
		BufferedReader socketInData = new BufferedReader(isr);
		
		// 출력버퍼에 쓰기 처리
		PrintWriter socketOutDataqRepo = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
		
		// 출력버퍼: 클라이언트에게 메시지 보내기
		socketOutDataqRepo.println("Welcome");
		
		String message = socketInData.readLine();
		System.out.println("From Client To Server : "+message);
		
		serverSocket.close();
		System.out.println("서버: 소켓 종료");
	}
	public static void main(String[] args) {
		try {
			new Server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

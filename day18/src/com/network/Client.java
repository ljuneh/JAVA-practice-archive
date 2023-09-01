package com.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
	
	public Client() throws IOException {
		Socket socket = new Socket("localhost", 10000);
		System.out.println("클라이언트: 연결 성공");
		
		
		
		// I/O 버퍼: 데이터 저장소
		// 입력버퍼에서 읽어오는 처리
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
		BufferedReader socketInDataReop = new BufferedReader(isr);
		
		// 출력버퍼에 쓰기 처리
		PrintWriter socketOutDataqRepo = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
		
		
		
		String message = socketInDataReop.readLine();
		System.out.println("From Server To Client : "+message);
		
		socketOutDataqRepo.println("첫 연결입니다. 반갑습니다.");
		
		socket.close();
		System.out.println("클라이언트: 소켓 종료");
	}
	public static void main(String[] args) {
		try {
			new Client();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


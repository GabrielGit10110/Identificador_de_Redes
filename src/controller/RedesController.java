package controller;

import java.io.*;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	private static String os () {
		String os = System.getProperty("os.name");
		return os;
	}
	
	private final String currentOs = os();
	
	public void ip() {
		
		try {
			if (currentOs.contains("Linux") || currentOs.contains("Mac")) {
				Process p = Runtime.getRuntime().exec("ip addr");
				readAllLinesUnix(p);

			} else if (currentOs.contains("Windows")) {
				Process p = Runtime.getRuntime().exec("IPCONFIG");
				readAllLinesWindows(p);
			}

		} catch (Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);
		}
	}
	
	public void ping() {
		
		try {
			if (currentOs.contains("Linux") || currentOs.contains("Mac")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("ping");
				buffer.append(" ");
				buffer.append("-4");
				buffer.append(" ");
				buffer.append("-c");
				buffer.append(" ");
				buffer.append("10");
				buffer.append(" ");
				buffer.append("www.google.com.br");

				Process p = Runtime.getRuntime().exec(buffer.toString());
				readAllLinesUnix(p);
			}
			
			if (currentOs.contains("Windows")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("ping");
				buffer.append(" ");
				buffer.append("-4");
				buffer.append(" ");
				buffer.append("-n");
				buffer.append(" ");
				buffer.append("10");
				buffer.append(" ");
				buffer.append("www.google.com.br");
			
				Process p = Runtime.getRuntime().exec(buffer.toString());
				readAllLinesWindows(p);
			}
			
		} catch (Exception e) {
			
		}
	}
	
	private void readAllLinesUnix(Process p) {

		InputStream inStream = p.getInputStream();
		InputStreamReader reader = new InputStreamReader(inStream);
		BufferedReader buffer = new BufferedReader(reader);
		try {
			String linha = buffer.readLine();

			while (linha != null) {
					if (linha.contains("inet ") && linha.contains("host")) { // exibe o endereco ip e o hostname
						String newLine = linha.trim();
						String[] ipAdress = newLine.split(" ");
						
						System.out.println("Usuario: " + ipAdress[4] + "\n" + "ip: " + ipAdress[1] + "\n");

					} 
					
					if (linha.contains("inet ") && linha.contains(" global ")) {
						String newLine = linha.trim();
						String[] ipAdress = newLine.split(" ");
						
						System.out.println("Usuario " + ipAdress[8] + "\n" + "ip: " + ipAdress[1] + "\n");
					}
					
					if (linha.contains("avg")) { // teste de tempo medio com ping para o google
						String[] averageTime = linha.split("/");
						System.out.println("Tempo médio PING: " + averageTime[4] + "ms");
						
					}
					
					linha = buffer.readLine();
			}
			
			buffer.close();
			inStream.close();
			reader.close();

		} catch (Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);

		}
		
	}
	
	private void readAllLinesWindows(Process p) {
		InputStream inStream = p.getInputStream();
		InputStreamReader reader = new InputStreamReader(inStream);
		BufferedReader buffer = new BufferedReader(reader);
		try {
			String linha = buffer.readLine();

			while (linha != null) {
				if (linha.contains("IPv4")) {
					String trimmedLine = linha.trim();
					String[] currentLine = trimmedLine.split(":");
					System.out.println("Endereco IP: " + currentLine[1]);

				}
				
				if (linha.contains(", M")) {
					String trimmedLine = linha.trim();
					String[] currentLine = trimmedLine.split(" = ");
					System.out.println("Tempo medio PING: " + currentLine[3]);
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			inStream.close();
			reader.close();

		} catch (Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);

		}	
	}
}

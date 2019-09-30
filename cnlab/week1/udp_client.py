import socket
HOST = '127.0.0.1' 
PORT = 65432     
mes = b"hi"
with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as s:
	s.sendto(mes ,(HOST,PORT))
	

import socket

HOST = ''  
PORT = 65432        

with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as s:
    s.bind((HOST, PORT))
    while True:
    	data, addr = s.recvfrom(1024);
    	print("message",data);

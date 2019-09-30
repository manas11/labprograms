import socket
HOST = '10.100.15.227' 
PORT = 12347    

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
	s.connect((HOST ,PORT))
	s.sendall(b"success hi")
	data = s.recv(1024)
	
print("Recieved", repr(data))



import socket
HOST = '127.0.0.1' 
PORT = 12348

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
	s.connect((HOST ,PORT))
	s.sendall(b"Current date")
	data = s.recv(1024)
	
print("Recieved", repr(data))



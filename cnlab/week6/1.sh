sudo ip netns add blue
sudo ip link add eth0 type veth peer name eth1
sudo ip link set eth0 netns blue
sudo ip netns exec blue ip link set lo up
sudo ip netns exec blue ip link set eth0 up
sudo ip netns exec blue ip address add 10.0.0.1/24 dev eth0
sudo ip address add 10.0.0.2/24 dev eth1
sudo ip link set eth1 up
ping 10.0.0.1





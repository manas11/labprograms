set terminal png
set output "cwnd.png"
set title "Congestion Window Plot"
set xlabel "Time (in Seconds)"
set ylabel "cwnd (in Bytes)"
set key outside right top
set style line 1 lw 2
set style line 2 lw 2
plot "TcpVariantsComparison-cwnd.data" using 1:2 with lines title "cwnd"

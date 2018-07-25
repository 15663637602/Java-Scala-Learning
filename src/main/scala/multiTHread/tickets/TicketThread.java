package multiTHread.tickets;

class TicketThread extends Thread {
    // 这里面的 5张票 没有被共享
    private int count = 5;
    private String name;
    private TicketThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (count > 0) {
            count --;
            System.out.println(name+" sold 1 ticket, rest: " + count);
        }
    }

    public static void main(String[] args) {
        TicketThread mt1 = new TicketThread("window1");
        TicketThread mt2 = new TicketThread("window2");
        TicketThread mt3 = new TicketThread("window3");

        mt1.start();
        mt2.start();
        mt3.start();
    }
}


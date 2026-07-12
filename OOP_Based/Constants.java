public final class Constants {
    public static final String APP_NAME = "MovieMate";
    public static final double GST_RATE = 18.0;
    public static final int MAX_SEATS = 150;
    public static final String DEFAULT_LANGUAGE = "English";
    //GST_RATE = 20.0; {Compiler time Error}
}
//class Movie extends Constants {Compile time error}
class Movie {
    String movieName;
    double duration;
    double ticketPrice;
    public Movie(String name, double dura, double tp) {
        this.movieName = name;
        this.duration = dura;
        this.ticketPrice = tp;
    }
    public final double generateTicketId() {
        return Math.random();
    }
    @Override
    public String toString() {
        return movieName + " " + duration + " " + ticketPrice +"\n";
    }
    
}
class PremiumMovie extends Movie {
    boolean VIPLounge = true;
    boolean compPopCorn = true;
    boolean reclinerSeats = true;
    public PremiumMovie(String name, double dura, double tp) {
        super(name,dura,tp);

    }
    // @Override
    // public int generateTicketId() {} [Error]
    @Override
    public String toString() {
        return movieName + " " + duration + " " + ticketPrice +"\n";
    }
}
class MainMethod {
    public static void main(String[] args) {
        Movie m = new Movie("Poor Things",2.59,4.99);
        double t = m.generateTicketId();
        System.out.println(m);
        System.out.println("Ticket ID: "+t);
    }
}


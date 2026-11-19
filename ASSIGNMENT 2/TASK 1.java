public class TicketGenerator {
    public static String generateTicket(String pnr, String passengerName,
                                        String coach, String seat, double fare) {
        StringBuilder sb = new StringBuilder(128);
        sb.append("PNR: ").append(pnr)
          .append(" | Passenger: ").append(passengerName)
          .append(" | Coach: ").append(coach)
          .append(" | Seat: ").append(seat)
          .append(" | Fare:  ").append(fare);
        return sb.toString();
    }

    public static class SharedLog {
        private final StringBuffer logBuffer = new StringBuffer();
        public synchronized void logBooking(String logMessage) {
            logBuffer.append(System.currentTimeMillis())
                      .append(" - ")
                      .append(logMessage)
                      .append("\n");
        }
        public String getLogs() {
            return logBuffer.toString();
        }
    }

    public static void main(String[] args) {
        String ticket = generateTicket("2415896310", "P.M. Dariga", "B2", "45", 850.00);
        System.out.println("--- Single Ticket Generation ---");
        System.out.println(ticket);

        SharedLog logger = new SharedLog();
        logger.logBooking("Booking confirmed for PNR 2415896310");
        System.out.println("\n--- Shared Booking Log ---");
        System.out.print(logger.getLogs());
    }
}

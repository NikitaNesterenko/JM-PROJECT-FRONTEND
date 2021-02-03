package jm.stockx.http.service.configuration;

public final class HttpClientConfigConstants {

    private HttpClientConfigConstants() {
    }

    // Connection pool
    public static  final int MAX_TOTAL_CONNECTIONS     = 40;
    public static  final int MAX_LOCALHOST_CONNECTIONS = 80;

    // Keep alive
    public static  final int DEFAULT_KEEP_ALIVE_TIME = 20 * 1000; // 20 sec

    // Timeouts
    public static  final int CONNECTION_TIMEOUT = 30 * 1000; // 30 sec, the time for waiting until a connection is established
    public static  final int REQUEST_TIMEOUT    = 30 * 1000; // 30 sec, the time for waiting for a connection from connection pool
    public static  final int SOCKET_TIMEOUT     = 60 * 1000; // 60 sec, the time for waiting for data
}
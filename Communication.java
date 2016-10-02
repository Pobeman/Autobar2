package main;

import java.io.InputStream;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;

public class Communication implements SerialPortEventListener {
	
	GUI window = null;
	
	public SerialPort serialPort = null;
	
	/** The port we're normally going to use. */
	private static final String PORT_NAMES[] = {
			"COM4" // Windows
	};
	
	/** Buffered input stream from the port */
	//private InputStream input = null;
	private InputStream input = null;
	
	public static int inputByte=0;
	/** The output stream to the port */
	//public static OutputStream output = null;
	public static OutputStream output = null;
	
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;

	public void initialize() {
		CommPortIdentifier portId = null;
		Enumeration<?> ports = CommPortIdentifier.getPortIdentifiers();

		// iterate through, looking for the port
		while (ports.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) ports
					.nextElement();
			
			if (currPortId.getName().equals(PORT_NAMES)) {
				portId = currPortId;
			}
		}
		
		//if it is unable to find port that arduino is connected to, it will exit program
		if (portId == null) {
			System.out.println("Could not find COM port.");
			System.exit(0);
		}

		try {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open(this.getClass().getName(),
					TIME_OUT);
			
			// set port parameters
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			// open the streams
			input = serialPort.getInputStream();
			output = serialPort.getOutputStream();
			
			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
			
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	/**
	 * This should be called when you stop using the port. This will prevent
	 * port locking on platforms like Linux.
	 */
	public synchronized void close(SerialPort serialPort) {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	/**
	 * Handle an event on the serial port. Read the data and print it.
	 */
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {	
				inputByte=this.input.read();
				System.out.println(inputByte);
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
	}
	
    public Communication(GUI window)
    {
        this.window = window;
    }
}
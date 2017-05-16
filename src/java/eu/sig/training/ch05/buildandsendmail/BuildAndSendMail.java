package eu.sig.training.ch05.buildandsendmail;

public class BuildAndSendMail {
    // tag::buildAndSendMail[]
    public void buildAndSendMail(MailMan m, Destination destination, String subject, MailFont font, String message1,
        String message2, String message3) {
        // Format the email address
        String mId = destination.getFirstname().charAt(0) + "." 
        	+ destination.getLastname().substring(0, 7) + "@"
            + destination.getDivision().substring(0, 5) + ".compa.ny";
        // Format the message given the content type and raw message
        MailMessage mMessage = formatMessage(font,
            message1 + message2 + message3);
        // Send message
        m.send(mId, subject, mMessage);
    }
    // end::buildAndSendMail[]

    @SuppressWarnings("unused")
    private MailMessage formatMessage(MailFont font, String string) {
        return null;
    }

    private class MailMan {

        @SuppressWarnings("unused")
        public void send(String mId, String subject, MailMessage mMessage) {}

    }

    private class MailFont {

    }

    private class MailMessage {

    }
    
    private class Message {
    	String subject;
    	String message;
    	
    	public Message(String subject, String message1, String message2, String message3) {
    		this.message = message1 + message2 + message3;
    	}

		public String getMessage() {
			return message;
		}
    	
    }
    
    private class Destination {
    	String firstname;
    	String lastname;
    	String division;
    	
		public Destination(String firstname, String lastname, String division) {
			super();
			this.firstname = firstname;
			this.lastname = lastname;
			this.division = division;
		}

		public String getFirstname() {
			return firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public String getDivision() {
			return division;
		}

		
    	
    }
    

}
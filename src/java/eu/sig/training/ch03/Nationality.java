package eu.sig.training.ch03;

public enum Nationality {
	
    DUTCH {
    	public Flag getFlag() {
    		return new DutchFlag();
    	}
    },
    
    GERMAN {
    	public Flag getFlag() {
    		return new GermanFlag();
    	}
    }, 
    BELGIAN {
    	public Flag getFlag() {
    		return new BelgianFlag();
    	}
    		
    }, 
    LUXEMBOURGER {
    	
    }, 
    FRENCH {
    	public Flag getFlag() {
    		return new FrenchFlag();
    	}
    }, 
    ITALIAN {
    	public Flag getFlag() {
    		return new ItalianFlag();
    	}
    }, 
    ROMANIA, 
    IRELAND, 
    HUNGARIAN, 
    BULGARIAN, 
    RUSSIA, 
    UNCLASSIFIED
    ; 
    
}
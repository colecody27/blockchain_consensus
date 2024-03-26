import java.util.ArrayList;
import java.util.Set;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node {
	double p_graph, p_malicious, p_txDistribution; 
	int numRounds;
	boolean[] followees;
	Set<Transaction> pendingTransactions; 

    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
    	this.p_graph = p_graph;
    	this.p_malicious = p_malicious;
    	this.p_txDistribution = p_txDistribution;
    	this.numRounds = numRounds;
    }

    public void setFollowees(boolean[] followees) {
        this.followees = followees;
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
    	this.pendingTransactions = pendingTransactions;
    }

    public Set<Transaction> getProposals() {
        return pendingTransactions; 
    }

    public void receiveCandidates(ArrayList<Integer[]> candidates) {
        // Convert int to transaction and insert into pending transactions 
    	for (Integer[] candidate : candidates ) {
    		Transaction transaction = new Transaction(candidate[0]); 
    		pendingTransactions.add(transaction); 
    	}
    }
}

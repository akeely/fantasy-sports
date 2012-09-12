package com.twoguysandadream.fantasy.auction.model;

public class LeagueSettings {

	private int salaryCap;
	private int rosterSize;
	private int minimumBid;
	private long bidTimeBufferMillis;
	private long bidTimeExtensionMillis;
	private long auctionLengthMillis;
	
	/**
	 * @return the salaryCap
	 */
	public int getSalaryCap() {
		return salaryCap;
	}
	/**
	 * @param salaryCap the salaryCap to set
	 */
	public void setSalaryCap(int salaryCap) {
		this.salaryCap = salaryCap;
	}
	/**
	 * @return the rosterSize
	 */
	public int getRosterSize() {
		return rosterSize;
	}
	/**
	 * @param rosterSize the rosterSize to set
	 */
	public void setRosterSize(int rosterSize) {
		this.rosterSize = rosterSize;
	}
	/**
	 * @return the bidTimeBufferMillis
	 */
	public long getBidTimeBufferMillis() {
		return bidTimeBufferMillis;
	}
	/**
	 * @param bidTimeBufferMillis the bidTimeBufferMillis to set
	 */
	public void setBidTimeBufferMillis(long bidTimeBufferMillis) {
		this.bidTimeBufferMillis = bidTimeBufferMillis;
	}
	/**
	 * @return the bidTimeExtensionMillis
	 */
	public long getBidTimeExtensionMillis() {
		return bidTimeExtensionMillis;
	}
	/**
	 * @param bidTimeExtensionMillis the bidTimeExtensionMillis to set
	 */
	public void setBidTimeExtensionMillis(long bidTimeExtensionMillis) {
		this.bidTimeExtensionMillis = bidTimeExtensionMillis;
	}
	/**
	 * @param auctionLengthMillis the auctionLengthMillis to set
	 */
	public void setAuctionLengthMillis(long auctionLengthMillis) {
		this.auctionLengthMillis = auctionLengthMillis;
	}
	/**
	 * @return the auctionLengthMillis
	 */
	public long getAuctionLengthMillis() {
		return auctionLengthMillis;
	}
	/**
	 * @param minimumBid the minimumBid to set
	 */
	public void setMinimumBid(int minimumBid) {
		this.minimumBid = minimumBid;
	}
	/**
	 * @return the minimumBid
	 */
	public int getMinimumBid() {
		return minimumBid;
	}
}

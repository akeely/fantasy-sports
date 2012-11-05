<%@page
	import="com.twoguysandadream.fantasy.auction.model.AuctionPlayer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Current Auction Players</title>
</head>
<body>
    <p>
        Displaying <c:out value="${fn:length(auctionPlayers)}" /> players currently up for auction.
    </p>
	<ul>
		<c:forEach var="auctionPlayer" items="${auctionPlayers}">
			<li>
			    <c:out value="${auctionPlayer.player.name}" /> - $
			    <c:out value="${auctionPlayer.bid}" />
			</li>
		</c:forEach>
	</ul>
</body>
</html>
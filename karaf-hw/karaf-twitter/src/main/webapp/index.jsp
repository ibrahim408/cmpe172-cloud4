<!-- Author: Jie Peng Hu -->
<html>
<head>
<title>Karaf/Twitter assignment</title>
</head>
<body>
	<jsp:include page="/WEB-INF/topHeader.jsp"></jsp:include>

	<h3>Twitter REST APIs</h3>
	<h4>Timeline API</h4>
	<p>Retrieves the latest <b>number</b> tweets by the specified <b>Twitter username</b>.<br>Includes retweets as well. Implements Twitter's Get Tweet Timelines API: https://api.twitter.com/1.1/statuses/user_timeline.json</p>
	<form method="POST" action="timelinetweets">
		<input name="user" type="text" placeholder="Twitter username">
		<input name="count" type="number" placeholder="Number of tweets" min="1" max="200" value="1">
		<input type="submit" value="click">
	</form>
	
	<h4>Search Tweet API</h4>
	<p>Retrieves the latest tweets from the <b>input</b> box below. It implements Twitter's Search Tweets API</p> 
	</form>
		<form method="POST" action="searchtweets">
		<input name="tweet" type="text" placeholder="Enter tweet to search">
		<input type="submit" value="search">
	</form>
	

	<h4> Followers API </h4>
	<p>Returns a list of followers for the specified user</p>
	<form method="POST" action="followers">
		<input name="username" type="text" placeholder="Enter username">
		<input type="submit" value="DisplayFollowers">
	</form>	
	
	<h4> Following API </h4>
	<p>Returns a list of friends for the specified user</p>
	<form method="POST" action="following">
		<input name="username" type="text" placeholder="Enter username">
		<input type="submit" value="DisplayFollowing">
	</form>	
	
	<h4> Favorites API </h4>
	<p>Returns the recent Tweets liked by specified user </p>
	<form method="POST" action="favorites">
		<input name="username" type="text" placeholder="Enter username">
		<input type="submit" value="DisplayFavorites">
	</form>	

	<h4>Trending Topic API</h4>
	<p>Retrieves the latest <b>number</b> trending topic from Twitter's Get Trends/Place API</p>
	<form method="POST" action="trendingtweets">
		<input name="numberOfTopic" type="number" placeholder="Number of results" min="1" max="23" value="1">
		<input type="submit" value="Explore Trending">
	</form>

</body>
</html>

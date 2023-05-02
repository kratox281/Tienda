<html>
<body>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
		crossorigin="anonymous">
<%request.getSession().setAttribute("logged", "no"); %>
	<%
	if (!request.getSession().isNew()) {

		request.removeAttribute("error");
	}
	%>

	<%@include file="fragments/Header.jsp"%>
 <div class="col-12 center" style="text-align: center; margin-top:7%">	     
	 		<img src="https://static.doofinder.com/main-files/uploads/2020/05/vender-una-tienda-online.jpg" class="img-fluid" />
		</div>
		<iframe style="border-radius:12px" src="https://open.spotify.com/embed/track/0zOtZOvUZ31UeWekN6ESg5?utm_source=generator&theme=0" width="100%" height="152" frameBorder="0" allowfullscreen="" allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture" loading="lazy"></iframe>    	
	<%@include file="fragments/Footer.jsp"%>


</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- 继承外部文件头 -->
<%@ include file="../publictemp/head.jsp"%>

<body>
	<div class="header">

		<c:if test="${username != null}">

			<%@ include file="../publictemp/headtop_desc_logined.jsp"%>

		</c:if>
		<c:if test="${username == null}">
			<%@ include file="../publictemp/headertop_desc.jsp"%>
		</c:if>


		<div class="wrap">
			<%@ include file="../publictemp/header_top.jsp"%>
		</div>
	</div>

	<div class="main">
		<div class="wrap">
			<div class="content_top">
				<div class="back-links">
					<p>
						<a href="index.html">Home</a> &gt;&gt;&gt;&gt; <a href="#"
							class="active">English</a>
					</p>
				</div>
				<div class="clear"></div>
			</div>
			<div class="section group">
				<div class="cont-desc span_1_of_2">
					<div class="product-details">
						<div class="grid images_3_of_2">
							<img src="${pageContext.request.contextPath}/${itemsCustom.pic}"
								alt="" />
						</div>
						<div class="desc span_3_of_2">
							<h2>${itemsCustom.name }</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore.</p>
							<div class="price">
								<p>
									Price: <span>$${itemsCustom.price }</span>
								</p>
							</div>
							<div class="available">
								<ul>
									<li><span>Model:</span> &nbsp; Model 1</li>
									<li><span>Shipping Weight:</span>&nbsp; 5lbs</li>
									<li><span>Units in Stock:</span>&nbsp; 566</li>
								</ul>
							</div>
							<div class="share-desc">
								<div class="share">
									<p>Number of units :</p>
									<input class="text_box" type="text">
								</div>
								<div class="button">
									<span><a href="${pageContext.request.contextPath}/items/addOrder.action?id=${itemsCustom.id }">Add to Cart</a>
									</span>
								</div>
								<div class="clear"></div>
							</div>
							<div class="wish-list">
								<ul>
									<li class="wish"><a href="#">Add to Wishlist</a>
									</li>
									<li class="compare"><a href="#">Add to Compare</a>
									</li>
								</ul>
							</div>
						</div>
						<div class="clear"></div>
					</div>
					<div class="product_desc">
						<h2>Details :</h2>
						<p>
							${itemsCustom.detail }
						</p>
					</div>
				</div>
				<div class="rightsidebar span_3_of_1 sidebar">
					<h2>Specials</h2>
					
					<c:forEach items="${items }" var="item">

						<div class="special_movies">
							<div class="movie_poster">
								<a href="${pageContext.request.contextPath}/items/preview.action?id=${item.id }"><img src="${pageContext.request.contextPath}/${item.pic }"
									alt="" />
								</a>
							</div>
							<div class="movie_desc">
								<h3>
									<a href="#">${item.name }</a>
								</h3>
								<p>
									<span>$${item.price }</span> &nbsp; $${item.price }
								</p>
								<span><a href="${pageContext.request.contextPath}/items/preview.action?id=${item.id }">Add to Cart</a>
								</span>
							</div>
							<div class="clear"></div>
						</div>

					</c:forEach>
					
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="wrap">
			<div class="section group">
				<div class="col_1_of_4 span_1_of_4">
					<h4>Information</h4>
					<ul>
						<li><a href="#">About Us</a>
						</li>
						<li><a href="#">Customer Service</a>
						</li>
						<li><a href="#">Advanced Search</a>
						</li>
						<li><a href="#">Orders and Returns</a>
						</li>
						<li><a href="contact.html">Contact Us</a>
						</li>
					</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Why buy from us</h4>
					<ul>
						<li><a href="#">About Us</a>
						</li>
						<li><a href="#">Customer Service</a>
						</li>
						<li><a href="#">Privacy Policy</a>
						</li>
						<li><a href="contact.html">Site Map</a>
						</li>
						<li><a href="#">Search Terms</a>
						</li>
					</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>My account</h4>
					<ul>
						<li><a href="contact.html">Sign In</a>
						</li>
						<li><a href="index.html">View Cart</a>
						</li>
						<li><a href="#">My Wishlist</a>
						</li>
						<li><a href="#">Track My Order</a>
						</li>
						<li><a href="contact.html">Help</a>
						</li>
					</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Contact</h4>
					<ul>
						<li><span>+91-123-456789</span>
						</li>
						<li><span>+00-123-000000</span>
						</li>
					</ul>
					<div class="social-icons">
						<h4>Follow Us</h4>
						<ul>
							<li><a href="#" target="_blank"><img
									src="./images/facebook.png" alt="" />
							</a>
							</li>
							<li><a href="#" target="_blank"><img
									src="./images/twitter.png" alt="" />
							</a>
							</li>
							<li><a href="#" target="_blank"><img
									src="./images/skype.png" alt="" /> </a>
							</li>
							<li><a href="#" target="_blank"> <img
									src="./images/linkedin.png" alt="" />
							</a>
							</li>
							<div class="clear"></div>
						</ul>
					</div>
				</div>
			</div>
			<div class="copy_right">
				<p>
					Company Name © All rights Reseverd | Design by <a
						href="http://w3layouts.com">W3Layouts</a>
				</p>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<a href="#" id="toTop"><span id="toTopHover"> </span>
	</a>
</body>
</html>


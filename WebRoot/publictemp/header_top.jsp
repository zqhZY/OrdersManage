<div class="header_top">
	<div class="logo">
		<a href="index.html"><img
			src="${pageContext.request.contextPath}/images/logo.png" alt="" /> </a>
	</div>
	<div class="header_top_right">
		<div class="cart">
			<p>
				<span>Cart</span>
			<div id="dd" class="wrapper-dropdown-2">
				(empty)
				<ul class="dropdown">

					<c:if test="${orderlist != null}">
						
						<c:forEach items="${orderlist }" var="order">

						<li>you have no items in your Shopping cart2</li>
						
					</c:forEach>
						
					</c:if>
					
					<c:if test="${orderlist == null }">
						
						<li>you have no items in your Shopping cart</li>
					</c:if>
					
					
				</ul>
			</div>
			</p>
		</div>
		<div class="search_box">
			<form>
				<input type="text" value="Search" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Search';}"><input
					type="submit" value="">
			</form>
		</div>
		<div class="clear"></div>
	</div>
	<script type="text/javascript">
		function DropDown(el) {
			this.dd = el;
			this.initEvents();
		}
		DropDown.prototype = {
			initEvents : function() {
				var obj = this;

				obj.dd.on('click', function(event) {
					$(this).toggleClass('active');
					event.stopPropagation();
				});
			}
		}

		$(function() {

			var dd = new DropDown($('#dd'));

			$(document).click(function() {
				// all dropdowns
				$('.wrapper-dropdown-2').removeClass('active');
			});

		});
	</script>
	<div class="clear"></div>
</div>

<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:bundle basename="property.text" prefix="label.">

 <c:choose>
            <c:when test="${sessionScope.userByLoginAndPassword == null}">
            <form action="jsp/common/login.jsp" method="post">
                            <input type="hidden" name="command" value="login"/>
                            <button type="submit" class="btn btn-link"><fmt:message key="login_key"/></button>
                        </form>
            </c:when>
            <c:otherwise>
 <div class="container p-3">
        <div class="btn-group">
            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="back_to_home_page"/>
                <button type="submit" class="btn btn-link"><fmt:message
                        key="home_key"/></button>
            </form>

            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="to_menu_page"/>
                <button type="submit" class="btn btn-link" name="page" value="1"><fmt:message
                        key="menu_key"/></button>
            </form>

            <form action="${pageContext.request.contextPath}/controller" method="post">
                <input type="hidden" name="command" value="to_account_page"/>
                <button type="submit" class="btn btn-link"><fmt:message key="account_key"/></button>
            </form>

            <c:if test="${sessionScope.userByLoginAndPassword.role == 2}">
             <form action="${pageContext.request.contextPath}/controller" method="post">
                 <input type="hidden" name="command" value="to_basket_page"/>
                 <button type="submit" class="btn btn-link"><fmt:message key="basket_key"/></button>
             </form>
            </c:if>
                <form action="${pageContext.request.contextPath}/controller" method="post">
                            <input type="hidden" name="command" value="logout"/>
                            <button type="submit" class="btn btn-link"><fmt:message key="logout_key"/></button>
                        </form>

        </div>
    </div>
</c:otherwise>
 </c:choose>
    </fmt:bundle>
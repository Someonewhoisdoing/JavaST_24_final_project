<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:bundle basename="property.text" prefix="label.">

    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            .footer {
                position: fixed;
                left: 0;
                bottom: 0;
                width: 100%;
                background-color: white;
                color: black;
                text-align: center;
            }
        </style>
    </head>

    <body>
    <div class="footer">
        <p style="margin: 16px"><fmt:message key="footer_key"/></p>
    </div>
    </body>

</fmt:bundle>
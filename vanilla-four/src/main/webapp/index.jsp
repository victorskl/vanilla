<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome to vanilla-four</title>
    <style type="text/css">
        body {
            font-family: 'Segoe UI', Verdana, Arial, sans-serif;
        }

        #container {
            margin: 50px 20% 0;
        }

        #clip {
            position: fixed;
            left: 0;
            top: 0;
            z-index: -1;
        }

        #clip:before {
            content: "4";
            font-size: 30.0em;
            text-align: center;
            display: block;
            opacity: 0.2;
        }
    </style>
</head>
<body>
<div id="container">
    <h1>Good day...</h1>

    <p>Welcome to Vanilla <a style="font-weight: bold" href="https://github.com/victorskl/vanilla/tree/master/vanilla-four">FOUR</a></p>
    <pre>git clone https://github.com/victorskl/vanilla.git</pre>

    <iframe src="https://ghbtns.com/github-btn.html?user=victorskl&amp;type=follow" frameborder="0" scrolling="no" width="170px" height="20px"></iframe>

    <hr/>

    <h2>Vaadin multi servlet with sub-path namespace</h2>
    <ul>
        <li><a href="simple">Simple UI with <code>/simple</code> servlet sub-path</a></li>
    </ul>

    <h2>Vaadin with Spring</h2>
    <p>
        <cite>mock 'V4 Enterprise Product Tracking System'</cite>
    </p>

    <ul>
        <li><a href="product">Vaadin Page-base Views using Navigator, Binding Components to Data using Vaadin Data Model</a></li>
        <li><a href="product/desktop">Product Desktop example using CustomLayout - Single-page Application (SPA)</a></li>
    </ul>
</div>
<div id="clip"></div>
</body>
</html>
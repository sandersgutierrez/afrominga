<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Google Cloud Hello World</title>
  </head>
  <body>
    <h1>Google Cloud Hello World</h1>
    <p>This is a sample HTML file. Click <a href="/hello">here</a> to see content served from a servlet.</p>
    <p>Learn more at <a href="https://happycoding.io">HappyCoding.io</a>.</p>
    <p>The current time is: <%= new Date().toString() %></p>
  </body>
</html>
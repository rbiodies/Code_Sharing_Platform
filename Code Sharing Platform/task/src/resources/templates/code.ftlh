<html lang="en">
<head>
    <title>Latest</title>
    <style>
        span {
            color: green;
        }
        pre {
            width: 600px;
            background-color: lightgray;
            padding: 10px 10px 10px 10px;
            border: solid gray;
        }
    </style>
</head>
<body>
<#list codes as code>
    <span id="load_date">${code.date}</span><pre id="code_snippet">${code.code}</pre>
</#list>
</body>
</html>
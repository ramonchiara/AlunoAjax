<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script type="text/javascript">
            function calcula() {
                $.ajax({
                    url: 'aluno-servlet',
                    method: 'GET',
                    data: {
                        nome: $('#nome').val(),
                        p1: $('#p1').val(),
                        p2: $('#p2').val()
                    },
                    success: function (data) {
                        $('#media').val(data.media);
                        $('#aprovado').val(data.aprovado);
                    }
                });
            }
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="aluno-servlet" method="GET">
            Nome: <input type="text" id="nome" name="nome"/><br/>
            P1: <input type="text" id="p1" name="p1"/><br/>
            P2: <input type="text" id="p2" name="p2"/><br/>
            <input type="button" value="Calcula" onclick="calcula()"/><br/>
            Média: <input type="text" id="media"/><br/>
            Aprovado: <input type="text" id="aprovado"/><br/>
        </form>
    </body>
</html>

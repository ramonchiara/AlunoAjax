$(document).ready(function () {
    $('#calcular').click(function () {
        $.ajax({
            url: 'Aluno',
            method: 'get',
            data: {
                nome: $('#nome').val(),
                p1: $('#p1').val(),
                p2: $('#p2').val()
            },
            success: function (data, textStatus, jqXHR) {
                $('#media').val(data.media);
                $('#aprovado').val(data.aprovado ? 'Sim' : 'Não');
            },
            statusCode: {
                400: function (jqXHR, textStatus, errorThrown) {
                    var data = JSON.parse(jqXHR.responseText);
                    alert(data.erro);
                }
            }
        });
    });
});

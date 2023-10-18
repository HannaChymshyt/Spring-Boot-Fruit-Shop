$(function() {

    $('#orderModalBtnSend').click(function(e) {
		e.preventDefault();
		$("#orderModalBtnCancel").prop("disabled", true);
		$("#orderModalBtnSend").prop("disabled", true);
		$('#orderModalSpinner').show();

        let formData = new FormData();
		formData.append('userName', $('input[id=nameInputOrder]').val());
		formData.append('userPhone', $('input[id=phoneInputOrder]').val());
		formData.append('userEmail', $('input[id=emailInputOrder]').val());
		formData.append('userOrderMsg', $('textarea[id=orderMsgTextareaOrder]').val());

        $.ajax({
            type: 'POST',
			dataType: 'json',
			contentType: false,
			processData: false,
			url: './order',
			data: formData
        })
        .done(function(response) {
            if(response.success == false) {
                output = "<span style='color: #f02d1f; font-size: 16px;'>" + response.message + "</span>";
            }else {
                output = "<span style='color: #22a131; font-size: 16px;'>" + response.message + "</span>";
            }
            $('#orderModalSpinner').hide();
            $('#orderModalResponse').html(output);
            $("#orderModalBtnCancel").prop("disabled", false);
            $("#orderModalBtnSend").prop("disabled", false);

        })
        .fail (function(e) {
            $('#orderModalSpinner').hide();
            $("#orderModalResponse").html(e.responseText);
            $("#orderModalBtnCancel").prop("disabled", false);
            $("#orderModalBtnSend").prop("disabled", false);
        });
    });

    $('#orderModalBtnCancel').click(function(e) {
        $('#orderModalForm')[0].reset();
        $('#orderModalResponse').html('');
        location.reload();
    });

});

$(function () {

    /* 在席情報更新 */
    $('nav select').change(function() {
        var selectedTxt = $(this).children('option:selected').val();
        var kakioki = $("nav input[type='text']");
        var koushin = $("nav input[type='submit']");

        koushin.removeClass('btn-default');
        koushin.addClass('btn-warning');

        if (selectedTxt !== '在席中') {
            kakioki.focus();
            kakioki.removeAttr('disabled');
            koushin.removeAttr('disabled');
        } else {
            kakioki.val('');
            kakioki.attr('disabled', 'true');
        }
    });

});
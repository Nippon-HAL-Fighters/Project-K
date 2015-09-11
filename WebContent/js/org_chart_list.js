$(function() {

    $('.delete_link').click(function(event) {
        event.preventDefault();

        var title = $(this).parents('tr').find('.title_link').html();
        var confirmMsg = title + 'を削除します。よろしいですか？';

        if (window.confirm(confirmMsg)) {
            $.ajax({
                url: $(this).attr('href'),
                method: 'DELETE'
            }).done(function() {
                location.reload();
            });
        }
    });

});
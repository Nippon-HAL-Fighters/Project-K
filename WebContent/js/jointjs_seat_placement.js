$(function() {

	/** JointJS **/
	var graph = new joint.dia.Graph;

    graph.on('remove', function(cell) {
        var rmIdx = _.indexOf(cells, cell);
        cells.splice(rmIdx, 1);
    });

    graph.on('change', function(cell) {
        isSaved = false;
    });

	var cells = [];

	/* 描画領域の作成 */
	var $editArea = $('.edit_area');

	var editArea = {
			width: $editArea.innerWidth(),
			height: $editArea.innerHeight()
	};

	var paper = new joint.dia.Paper({
		el : $editArea,
		width : editArea.width,
		height : editArea.height,
		gridSize : 1,
		model : graph
	});

	// アイテムクリック時のコマンド
	paper.on('cell:pointerup', function(cellView) {
	    if (cellView.model instanceof joint.dia.Link) return;

	    var halo = new joint.ui.Halo({ graph: graph, paper: paper, cellView: cellView });
	    halo.render();
	});

	// 編集時の線表示
    var snaplines = new joint.ui.Snaplines({ paper: paper });
    snaplines.startListening();

    // redo undo マネージャー
    var commandManager = new joint.dia.CommandManager({ graph: graph });

	/* 作成ボタン押下アクション */
	$('.item').click(function() {
		var selected = $(this).val();
		switch (selected) {
		case 'undo':
			commandManager.undo();
			break;
		case 'redo':
			commandManager.redo();
			break;
		case '印刷':
			//paper.print();
			print();
			break;
		case '保存':
			save();
			break;
		default:
			break;
		}
	});

	/*
	$.ajax({
        url: './SeatPlacementServlet',
        dataType: 'json'
    }).done(function(data) {
        graph.fromJSON(data);
        graph.set('id', id);
    });
	*/
     var templateJSON = '{"cells":[{"type":"basic.Rect","position":{"x":116,"y":80},"size":{"width":100,"height":60},"angle":0,"id":"7c73b6a6-9371-4eed-afd0-ed07327ad697","embeds":"","z":1,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":216,"y":80},"size":{"width":100,"height":60},"angle":0,"id":"c446f5a4-0a7d-431a-bbf1-5314f0eb63be","embeds":"","z":2,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":316,"y":80},"size":{"width":100,"height":60},"angle":0,"id":"445a183d-5840-423f-84b4-fa12a6acb2a9","embeds":"","z":3,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":116,"y":140},"size":{"width":100,"height":60},"angle":0,"id":"36e6bad8-bfd5-4437-8396-c56b9bda3890","embeds":"","z":4,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":216,"y":140},"size":{"width":100,"height":60},"angle":0,"id":"74374b01-d733-41ae-8099-1f0a82d8b47f","embeds":"","z":5,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":316,"y":140},"size":{"width":100,"height":60},"angle":0,"id":"b2b5d7bf-324d-4fd1-96e8-b034069c4d8a","embeds":"","z":6,"attrs":{"rect":{"fill":"white"}}}]}';
	 graph.fromJSON(JSON.parse(templateJSON));


});
/** $(function(){}); end * */

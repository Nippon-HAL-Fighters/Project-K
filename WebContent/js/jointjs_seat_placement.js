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

	//var templateJSON = {"cells":[{"type":"basic.Rect","position":{"x":43,"y":30},"size":{"width":100,"height":60},"angle":0,"id":"f0d84580-915d-4ae9-b2a8-29d95d10edbe","z":1,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":143,"y":30},"size":{"width":100,"height":60},"angle":0,"id":"d62fd95e-9149-4f47-95ba-aa41f6c93343","embeds":"","z":2,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":243,"y":30},"size":{"width":100,"height":60},"angle":0,"id":"83d9bc08-b6ef-40d5-acbf-6d38d3c3e349","embeds":"","z":3,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":343,"y":30},"size":{"width":100,"height":60},"angle":0,"id":"93447b58-1fb3-4222-9fa1-8de0939c3789","embeds":"","z":4,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":343,"y":90},"size":{"width":100,"height":60},"angle":0,"id":"5aafe624-c6dc-4305-8cec-e6ad521a3750","embeds":"","z":5,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":243,"y":90},"size":{"width":100,"height":60},"angle":0,"id":"6dacadff-496d-4e54-9a96-022397cb06d6","embeds":"","z":6,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":143,"y":90},"size":{"width":100,"height":60},"angle":0,"id":"c374222c-d5eb-4908-9196-d471f1fdf6db","embeds":"","z":7,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":43,"y":90},"size":{"width":100,"height":60},"angle":0,"id":"ee7f002d-66c3-4b14-a659-0e9c2d121d0a","embeds":"","z":8,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":13,"y":178},"size":{"width":468,"height":10},"angle":0,"id":"c5c869b6-f213-4f5c-a72d-e92ca54bf6bf","z":9,"attrs":{"rect":{"fill":"orange"}}},{"type":"basic.Rect","position":{"x":43,"y":202},"size":{"width":100,"height":60},"angle":0,"id":"5ae13591-d528-4414-8c15-d59b176aba71","z":10,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":143,"y":262},"size":{"width":100,"height":60},"angle":0,"id":"08264866-114e-4cc5-b681-e121a78e2d2f","embeds":"","z":11,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":243,"y":202},"size":{"width":100,"height":60},"angle":0,"id":"c4d514db-9ca0-484d-9773-bb5b5aadc975","embeds":"","z":12,"attrs":{"rect":{"fill":"white"}}},{"type":"basic.Rect","position":{"x":343,"y":262},"size":{"width":100,"height":60},"angle":0,"id":"d5e02bd7-e077-4d3d-8238-04574b22dd86","embeds":"","z":13,"attrs":{"rect":{"fill":"white"}}}]}
	//graph.fromJSON(JSON.parse(templateJSON));

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


	var desk = new joint.shapes.basic.Rect({
		position : { x: 20, y:20 },
		size : { width : 100, height : 60 },
		attrs : { rect : { fill : 'white' } }
	});

	graph.addCell(desk);

});
/** $(function(){}); end * */

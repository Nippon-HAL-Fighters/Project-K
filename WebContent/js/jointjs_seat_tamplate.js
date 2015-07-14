$(function() {

	/** JointJS **/
	var graph = new joint.dia.Graph;

	/* 保存したデータの送り先 */
	graph.url = "/Project-K/SeatTemplate";
	console.log(graph.url);

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
	var $itemArea = $('.item_area');

	var editArea = {
			width: $editArea.innerWidth(),
			height: $editArea.innerHeight()
	};

	var itemArea= {
			width: $itemArea.innerWidth(),
			height: $itemArea.innerHeight()
	}

	/* メイン編集領域 */
	var paper = new joint.dia.Paper({
		el : $editArea,
		width : editArea.width,
		height : editArea.height,
		gridSize : 1,
		model : graph
	});

	/* アイテム表示領域 */
	var stencil = new joint.ui.Stencil({
		   graph: graph,
		   paper: paper,
		   width: 200,
		   height: 300
	});
	$itemArea.append(stencil.render().el);

	// アイテムクリック時のコマンド
	paper.on('cell:pointerup', function(cellView) {
	    if (cellView.model instanceof joint.dia.Link) return;

	    var halo = new joint.ui.Halo({ graph: graph, paper: paper, cellView: cellView });
	    halo.render();
	});

	var selection = new Backbone.Collection;
	var selectionView = new joint.ui.SelectionView({ paper: paper, graph: graph, model: selection });

	paper.on('blank:pointerdown', selectionView.startSelecting);

	paper.on('cell:pointerup', function(cellView, evt) {
	     if ((evt.ctrlKey || evt.metaKey) && !(cellView.model instanceof joint.dia.Link)) {
	             selection.add(cellView.model);
	             selectionView.createSelectionBox(cellView);
	     }
	});

	selectionView.on('selection-box:pointerdown', function(evt) {
	     if (evt.ctrlKey || evt.metaKey) {
	             var cell = selection.get($(evt.target).data('model'));
	             selection.reset(selection.without(cell));
	             selectionView.destroySelectionBox(paper.findViewByModel(cell));
	     }
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


	/** 描画機能 * */

	/* 机の描画 */
	var desk = new joint.shapes.basic.Rect({
		position : { x: 20, y:20 },
		size : { width : 100, height : 60 },
		attrs : { rect : { fill : 'white' } }
	});

	/* 丸の描画 */
	var circle = new joint.shapes.basic.Circle({
	    position: { x: 20, y: 100 },
	    size: { width: 50, height: 50 }
	});

	/* 仕切りの描画 */
	var partition = new joint.shapes.basic.Rect({
		position : { x: 20, y: 180 },
		size : { width : 100, height : 10 },
		attrs : { rect : { fill : 'orange' } }
	});

	stencil.load([desk, circle, partition]);

	/* 新しいタブでPNG画像として表示する処理 */
	function print() {
		var windowFeatures = 'menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=yes';
		var windowName = _.uniqueId('png_output');
		var imageWindow = window.open('', windowName, windowFeatures);
		paper.toPNG(function(dataURL) {
    	    imageWindow.document.write('<img src="' + dataURL + '"/>');
		});
	}

	/* 保存処理 */
	function save(){
		var user = window.prompt("保存名を入力してください", "");
		console.log(user);


		var res = graph.save(null, {
            dataType: 'text',
            success: function() {
                alert('保存しました');
                sampleForm(user);
                isSaved = true;
            },
            error: function() {
                alert('保存に失敗しました');
            }
        });
	}

	function sampleForm( value ){
	    var form = document.createElement( 'form');
	    form.setAttribute( 'action' , graph.url );
	    form.setAttribute( 'method' , 'post' );
	    document.body.appendChild( form );
	    var input = document.createElement( 'input' );
	    input.setAttribute( 'type' , 'hidden' );
	    input.setAttribute( 'name' , 'name' );
	    input.setAttribute( 'value' ,value );
	    form.appendChild( input );

	    form.submit();
	}

});
/** $(function(){}); end * */

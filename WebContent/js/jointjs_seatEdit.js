$(function() {

	/** JointJS * */
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
	var $editArea = $('#editArea');
	var editArea = {
		width : $('#editArea').innerWidth(),
		height : $('#editArea').innerHeight()
	};

	var paper = new joint.dia.Paper({
		el : $editArea,
		width : editArea.width,
		height : editArea.height,
		gridSize : 10,
		model : graph
	});

	/* 作成ボタン押下アクション */
	$('.button').click(function() {
		var selected = $(this).val();
		switch (selected) {
		case '机':
			createDesk();
			break;
		case '丸':
			createCircle();
			break;
		case 'しきり':
			createPartition();
			break;
		case '印刷':
			paper.print();
			break;
		default:
			break;
		}
	});

	/** 描画機能 * */

	var defaultPosition = {
		x : 10,
		y : 10
	};

	/* 机の描画 */
	function createDesk() {

		cells.push(new joint.shapes.basic.Rect({
			position : {
				x : defaultPosition.x,
				y : defaultPosition.y
			},
			size : {
				width : 100,
				height : 60
			},
			attrs : {
				rect : {
					fill : 'blue'
				},
				text : {
					text : '机',
					fill : 'white'
				}
			}
		}));

		graph.addCells(cells);
	}

	/* ボタン押下で「丸」の作成 */
	function createCircle() {

		cells.push(new joint.shapes.basic.Circle({
			position : defaultPosition,
			size : {
				width : 50,
				height : 50
			},
			attrs : {
				text : {
					text : '丸'
				},
				circle : {
					fill : '#2ECC71'
				}
			}
		}));

		graph.addCells(cells);
	}

	/* ボタン押下で仕切りの作成 */
	function createPartition() {

		cells.push(new joint.shapes.basic.Rect({
			position : defaultPosition,
			size : {
				width : 100,
				height : 20
			},
			attrs : {
				text : {
					text : '仕切り'
				},
				rect : {
					fill : 'orange'
				}
			}
		}));

		graph.addCells(cells);
	}

});
/** $(function(){}); end * */

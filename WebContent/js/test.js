$(function() {

	/** JointJS * */
	var graph = new joint.dia.Graph;

	var cells = [];

	/* 描画領域の作成 */
	var $editArea = $('.editArea');

	var editArea = {
	        width: function() {return $editArea.innerWidth();},
	        height: function() {return $editArea.innerHeight();}
	};

	var paper = new joint.dia.Paper({
		el : $editArea,
		width : editArea.width(),
		height : editArea.height(),
		gridSize : 10,
		model : graph
	});

	paper.on('cell:pointerup', function(cellView) {
	    if (cellView.model instanceof joint.dia.Link) return;

	    var halo = new joint.ui.Halo({ graph: graph, paper: paper, cellView: cellView });
	    halo.render();
	});

    var snaplines = new joint.ui.Snaplines({ paper: paper });
    snaplines.startListening();

    var rect = new joint.shapes.basic.Rect({
        position: { x: 100, y: 100 },
        size: { width: 70, height: 30 },
        attrs: { text: { text: 'my rectangle' } }
    });

    graph.addCell(rect);

});
/** $(function(){}); end * */

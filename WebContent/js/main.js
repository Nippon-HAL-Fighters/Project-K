var url;
var graph;
var paper;
var defaultPosition = "x : 100, y : 30";
var rect;
var circle
var line;

(function() {
	"use strict"

	$(function() {
		graph = new joint.dia.Graph;
		paper = new joint.dia.Paper({
			el : $('#myholder'),
			width : 600,
			height : 400,
			gridSize: 10,
			model : graph
		});

		url = "/Test";

	});
})();

/**  ボタン押下で四角形の作成 **/
function createRect() {

	rect = new joint.shapes.basic.Rect({
		position : defaultPosition ,
		size : { width : 100, height : 80 },
		attrs : { rect : { fill : 'blue' },
		text : { text : '机', fill : 'white' }}
	}).addTo(graph);
}


function createCircle() {

	circle = new joint.shapes.basic.Circle({
		position: defaultPosition,
		size: { width: 100, height: 100 },
		attrs: { text: { text: '丸' }, circle: { fill: '#2ECC71' } }
    }).addTo(graph);
}

function createLine() {

	line = new joint.shapes.basic.Rect({
		position : defaultPosition,
		size : { width : 100, height : 2 },
		attrs : { rect : { fill : 'blue' }}
	}).addTo(graph);
}

function save() {
	Backbone.Model.extend({
		urlRoot: '/test.html'
	})

	var myModel = new myodel();

	myModel.save({
		name: 'Hoge'
	});

	document.location = "/Test";
}
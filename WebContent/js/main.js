(function() {
  "use strict"

  $(function(){
    var graph = new joint.dia.Graph;
    var paper = new joint.dia.Paper({
      el: $('#left'),
      width: 1000,
      height: 1000,
      model: graph
    });

    var rect = new joint.shapes.basic.Rect({
      position: { x: 100, y: 30 },
      size: { width: 100, height: 30 },
      attrs: { rect: { fill: 'blue' }, text: { text: 'my box', fill: 'white' } }
    });

    var rect2 = rect.clone();
    rect2.translate(300);

    var link = new joint.dia.Link({
      source: { id: rect.id },
      target: { id: rect2.id }
    });
    graph.addCells([rect, rect2, link]);
  });
})();
$(function() {
    /* スタイル調整 */
    $('.box-text').css('border-radius', '0px 4px 4px 0px');

    var boxSubmit = {
        status: false,
        el: $('.box-submit'),
        type: 'tategaki',

        on: function() {
            this.el.removeAttr('disabled');
            this.status = !this.status;
        },
        off: function() {
            this.el.attr('disabled', '');
            this.status = !this.status;
        },
        submit: function(val) {
            switch (this.type) {
                case 'tategaki':
                    addBox.vertical(val);
                    break;
                case 'yokogaki':
                    addBox.horizon(val);
                    break;
            }
        }
    };

    var boxTypes = {
        'yokogaki': '横書きボックス',
        'tategaki': '縦書きボックス'
    };

    $('.box-type li').click(function(event) {
        event.preventDefault();
        var boxTypeText = myLastIndexOf(event.target.toString());
        boxSubmit.type = boxTypeText;
        $('.box-type button span:first').html(boxTypes[boxTypeText]);
    });

    $('.box-text').keyup(function() {
        if ($(this).val().length !== 0){
            boxSubmit.on();
        } else {
            boxSubmit.off();
        }
    });

    $('.box-submit').click(function() {
        boxSubmit.submit($('.box-text').val());
        boxSubmit.off();
    });

    /* JointJS */

    var $sosikizu = $('.sosikizu');

    var sosikizuInfo = {
        width: function() {return $sosikizu.innerWidth();},
        height: function() {return $sosikizu.innerHeight();}
    };

    /* 初期化 */

    var cells = [];

    var graph = new joint.dia.Graph;

    graph.on('remove', function(cell) {
        var rmIdx = _.indexOf(cells, cell);
        cells.splice(rmIdx, 1);
    });

    var graphLayout = new joint.layout.TreeLayout({
        graph: graph,
        verticalGap: 20,
        horizontalGap: 40
    });

    var paper = new joint.dia.Paper({
        el: $sosikizu,
        width: sosikizuInfo.width(),
        height: sosikizuInfo.height(),
        model: graph,
        gridSize: 1
    });

    paper.on('cell:pointerup', function(cellView) {
        if (cellView.model instanceof joint.dia.Link) {
            return;
        }

        var halo = new joint.ui.Halo({ graph: graph, paper: paper, cellView: cellView });
        halo.render();

        halo.on('action:remove:pointerdown', function(event) {
        });
    });

    var snaplines = new joint.ui.Snaplines({ paper: paper });
    snaplines.startListening();

    /* Functions */

    var addBox = {
        add: function() {
            graph.addCells(cells);
        },
        vertical: function(val) {
            var valArray = val.split('');

            var dispText = _.reduce(valArray, function(memo, val) {
                return memo + val + '\r\n';
            }, '');

            cells.push(new joint.shapes.basic.Rect({
                position: { x: 15, y: 20 },
                size: { width: 18, height: val.length * 16 },
                attrs: { rect: { fill: 'blue' }, text: { text: dispText, fill: 'white', 'ref-y': .6, 'ref-x': .6 } },
                rankDir: 'R'
            }));

            this.add();
        },
        horizon: function(val) {
            cells.push(new joint.shapes.basic.Rect({
                position: { x: 15, y: 20 },
                size: { width: val.length * 16, height: 18 },
                attrs: { rect: { fill: 'blue' }, text: { text: val, fill: 'white' } }
            }));

            this.add();
        }
    };

    $('.jinin').click(function() {
        graphLayout.prepare();
        graphLayout.layout();
    });

});

function myLastIndexOf(str) {
    var pos = str.indexOf('/');
    var lastPos = pos;

    while (pos !== -1) {
        pos = str.indexOf('/', pos + 1);

        if (pos !== -1) {
            lastPos = pos;
        }
    }

    return str.substring(lastPos + 1, str.length).toString();
}
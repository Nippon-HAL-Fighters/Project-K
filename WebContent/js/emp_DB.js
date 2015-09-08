var driver = "{SQL Server}";          // ODBCドライバ
var server = "localhost:8080"; // サーバ
var database = "ham";              // データベース
var user = "root";                      // ユーザ
var pass = "";                   // パスワード

/**
 * 「Connection」接続
 */
function openConnection() {
    // 「Connection」オブジェクト生成
    var con = new ActiveXObject("ADODB.Connection");
    // 接続文字列設定
    con.ConnectionString = "Provider=MSDASQL" // プロバイダ
        + ";DRIVER=" + driver                 // ODBCドライバ
        + ";SERVER=" + server                 // サーバ
        + ";DATABASE=" + database             // データベース
        + ";UID=" + user                      // ユーザ
        + ";PWD=" + pass;                     // パスワード
    // 接続
    con.Open();
    return con;
}

/**
 * 「Connection」切断
 */
function closeConnection(con) {
    try {
        // ステータスチェック
        if (con && con.State == 1) {
            // 切断
            con.Close();
        }
    } catch (e) {
        // エラーの場合
        WScript.Echo("Error(" + (e.number & 0xFFFF) + "):" + e.message);
    }
}



//「Connection」オブジェクト用変数
var con = null;
// 「Recordset」オブジェクト用変数
var rs = null;
try {
    // 接続
    con = openConnection();
    // 「Command」オブジェクト生成
    var cmd = new ActiveXObject("ADODB.Command");
    // 「Connection」オブジェクト設定
    cmd.ActiveConnection = con;
    // コマンドタイプをテキスト(1)に設定
    cmd.CommandType = 1;
    // 「Prepared」を真に設定
    cmd.Prepared = true;
    // 発行するコマンド文字列(SQL文)を設定
    cmd.CommandText = "SELECT * FROM ham";
    // パラメータを設定
    cmd.Parameters(0).Value = 0;
    // 実行
    rs = cmd.Execute();
    // 行番号
    var row = 1;
    // 「Recordset」が最後になるまでループ
    while (!rs.EOF) {
        // １行文字列
        var line = "" + row++;
        // フィールド数分ループ
        for (var i = 0; i < rs.Fields.Count; i++) {
            // フィールドの値、null判定
            if (rs.Fields(i).Value != null) {
                // フィールドタイプ判定
                if (rs.Fields(i).Type == 135) {
                    // 「日付/時刻スタンプ」型だったので、日付フォーマット
                    //line += " " + df(new Date(rs.Fields(i).Value));

                    // 「日付/時刻スタンプ」型以外だったので、そのまま
                    line += " " + rs.Fields(i).Value;
                }
            } else {
                // nullだったので、そのまま
                line += " " + rs.Fields(i).Value;
            }
        }
        // １行分出力
        WScript.Echo(line);
        // 次の行へ移動
        rs.MoveNext();
    }
} catch (e) {
    // エラーの場合
    WScript.Echo("Error(" + (e.number & 0xFFFF) + "):" + e.message);
} finally {
    try {
        // ステータスチェック
        if (rs && rs.State == 1) {
            // 「Recordset」を閉じる
            rs.Close();
        }
    } catch (e) {
        WScript.Echo("Error(" + (e.number & 0xFFFF) + "):" + e.message);
    }
    // 「Connection」切断
    closeConnection(con);
}

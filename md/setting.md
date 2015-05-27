# 環境設定

## Sassの設定

Sassを使うとCSSの中で変数が使えたり、入れ子構造ができたりでソースが見やすくなります☆
あと、Bootstrapのカスタマイズができるようになります。

詳しい使い方は[こちらのページ](http://www.atmarkit.co.jp/ait/articles/1402/17/news102_2.html)とかを参考にしてください。

Sassで書かれたファイル(拡張子「.sass」)をコンパイルするとCSSが出力されます。
コンパイルするのにRubyが必要なので、まずはRubyをインストールしましょう！

### Rubyのインストール

まずは以下からインストーラをダウンロードして実行してください。

+ [Ruby 2.2.2](http://dl.bintray.com/oneclick/rubyinstaller/rubyinstaller-2.2.2.exe)
+ [Ruby 2.2.2 64bitの人はこっち](http://dl.bintray.com/oneclick/rubyinstaller/rubyinstaller-2.2.2-x64.exe)

インストール途中、「**インストール先とオプションの指定**」のところで
「Rubyの実行ファイルへ環境変数PATHを設定する」にチェックを入れてください。

インストールが終わったら、コマンドプロンプトを開いて、
下の二つのコマンドを実行！バージョンが表示されればOK！

```
ruby -v
gem -v
```

ちなみにGemってのはRubyのプラグインを管理するツールです。

### Sassのインストール

コマンドプロンプトで以下のコマンドを実行してください。

```
gem install bundler
```

次に、Sassをコンパイルするための環境をインストールします。  
**Gemfile**という名前のファイルがあるディレクトリ(src/main/webapp)でコマンドプロンプトを開いて、以下のコマンドを実行。

```
bundle install
```


### Sassの使い方

**config.rb**という名前のファイルがあるディレクトリ(src/main/webapp)でコマンドプロンプトを開いて、
以下のコマンドを実行。

```
compass watch
```

すると、sassフォルダのファイルが変更される度に、
cssフォルダにCSSが出力されるようになります。
ちなみに、SassのエラーがあるとCSSにエラーが出力されます。

## Gitの設定

### Gitのインストール

[こちらのページ](https://git-scm.com/download/win)からダウンロードしたのを実行してください。

基本的には「Next」押して進めてもらってOKですが、「Adjusting your PATH enviroment」って画面で、
「**Run Git from Windows Command Prompt**」を選択してください。

### SourceTreeのインストール

GitをGUIから使えるツールをインストールします。

[こちらのページ](https://www.sourcetreeapp.com/)からダウンロードしたのを実行してください。
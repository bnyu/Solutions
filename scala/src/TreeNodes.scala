import scala.collection.mutable

case class TreeNodes[T](data: T, children: Seq[TreeNodes[T]] = Nil)

object TreeNodes {
  def asciiDisplay(root: TreeNodes[String]): Seq[String] = {
    if (root != null) {
      val column = new mutable.MutableList[String]()
      val header = "+-"
      val space = " "
      val line = "|"

      def display(root: TreeNodes[String], pre: String, lastOne: Boolean): Boolean = {
        column += pre + header + root.data
        val num = root.children.length
        if (num > 0) {
          val nextPre = if (lastOne) pre + space * 2 else pre + line + space
          for (i <- root.children.indices) {
            val node = root.children(i)
            val isLast = i == num - 1
            if (display(node, nextPre, isLast) && !isLast)
              column += nextPre + line
          }
          true
        } else false
      }

      display(root, "", lastOne = true)
      column += ""
      column
    } else Nil
  }

  def generateTreeNodes(input: String): TreeNodes[String] = {
    val stack = new mutable.ArrayStack[(Int, mutable.MutableList[TreeNodes[String]])]()
    var root: TreeNodes[String] = null
    var preI = -1
    for (s <- input.lines) {
      val i = s.indexOf("+-")
      if (i >= 0) {
        val data = s.substring(i + 2)
        val children = new mutable.MutableList[TreeNodes[String]]
        val node = TreeNodes(data, children)
        if (i == 0) {
          root = node
        } else if (i > preI) {
          stack.head._2 += node
        } else if (i == preI) {
          stack.pop()
          stack.head._2 += node
        } else if (i < preI) {
          while (stack.head._1 >= i) stack.pop()
          stack.head._2 += node
        }
        stack.push((i, children))
        preI = i
      }
    }
    root
  }
}

//
//import org.scalatest.FlatSpec
//
//class FirstSpec extends FlatSpec {
//  "sbt: \"inspect tree compile:compile\"" should "be text tree" in {
//    val input =
//      """+-Compile / compile = Task[xsbti.compile.CompileAnalysis]
//        |  +-Compile / compileIncSetup = Task[xsbti.compile.Setup]
//        |  | +-Global / classpathEntryDefinesClass = Task[scala.Function1[java.io.File, xsbti.compile.DefinesClass]]
//        |  | +-Compile / compile / compilerReporter = Task[xsbti.Reporter]
//        |  | | +-Global / maxErrors = 100
//        |  | | +-Global / sourcePositionMappers = Task[scala.collection.Seq[scala.Function1[xsbti.Position, scala.Option[xsbti.Position]]]]
//        |  | | +-Compile / compile / streams = Task[sbt.std.TaskStreams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | |   +-Global / streamsManager = Task[sbt.std.Streams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | |
//        |  | +-Global / skip = Task[Boolean]
//        |  | +-Compile / compileAnalysisFilename = Task[java.lang.String]
//        |  | | +-Global / crossPaths = true
//        |  | | +-scalaBinaryVersion = 2.12
//        |  | |
//        |  | +-Compile / compileIncSetup / streams = Task[sbt.std.TaskStreams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | | +-Global / streamsManager = Task[sbt.std.Streams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | |
//        |  | +-Global / compilerCache = Task[xsbti.compile.GlobalsCache]
//        |  | +-Compile / dependencyClasspath = Task[scala.collection.Seq[sbt.internal.util.Attributed[java.io.File]]]
//        |  | | +-Compile / dependencyClasspath / streams = Task[sbt.std.TaskStreams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | | | +-Global / streamsManager = Task[sbt.std.Streams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | | |
//        |  | | +-Compile / externalDependencyClasspath = Task[scala.collection.Seq[sbt.internal.util.Attributed[java.io.File]]]
//        |  | | | +-Compile / externalDependencyClasspath / streams = Task[sbt.std.TaskStreams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | | | | +-Global / streamsManager = Task[sbt.std.Streams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | | | |
//        |  | | | +-Compile / managedClasspath = Task[scala.collection.Seq[sbt.internal.util.Attributed[java.io.File]]]
//        |  | | | | +-Compile / classpathConfiguration = Task[sbt.librarymanagement.Configuration]
//        |  | | | | | +-Compile / configuration = compile
//        |  | | | | | +-Global / internalConfigurationMap = sbt.Defaults$$$Lambda$1141/1040172900@5463f035
//        |  | | | | | +-update = Task[sbt.librarymanagement.UpdateReport]
//        |  | | | | |
//        |  | | | | +-Global / classpathTypes = Set(eclipse-plugin, bundle, scala-jar, hk2-jar, orbit, jar)
//        |  | | | | +-Compile / managedClasspath / streams = Task[sbt.std.TaskStreams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | | | | | +-Global / streamsManager = Task[sbt.std.Streams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | | | | |
//        |  | | | | +-update = Task[sbt.librarymanagement.UpdateReport]
//        |  | | | |
//        |  | | | +-Compile / unmanagedClasspath = Task[scala.collection.Seq[sbt.internal.util.Attributed[java.io.File]]]
//        |  | | |   +-Global / buildDependencies = sbt.internal.BuildDependencies@e0d1dc4
//        |  | | |   +-Compile / configuration = compile
//        |  | | |   +-Global / settingsData = Task[sbt.internal.util.Settings[sbt.Scope]]
//        |  | | |   +-thisProjectRef = ProjectRef(file:/C:/Users/bnyu/Documents/IdeaProjects/exam/,exam)
//        |  | | |   +-Compile / unmanagedClasspath / streams = Task[sbt.std.TaskStreams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | | |     +-Global / streamsManager = Task[sbt.std.Streams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | | |
//        |  | | +-Compile / internalDependencyClasspath = Task[scala.collection.Seq[sbt.internal.util.Attributed[java.io.File]]]
//        |  | |   +-Global / buildDependencies = sbt.internal.BuildDependencies@e0d1dc4
//        |  | |   +-Compile / classpathConfiguration = Task[sbt.librarymanagement.Configuration]
//        |  | |   | +-Compile / configuration = compile
//        |  | |   | +-Global / internalConfigurationMap = sbt.Defaults$$$Lambda$1141/1040172900@5463f035
//        |  | |   | +-update = Task[sbt.librarymanagement.UpdateReport]
//        |  | |   |
//        |  | |   +-Compile / configuration = compile
//        |  | |   +-Compile / internalDependencyClasspath / streams = Task[sbt.std.TaskStreams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | |   | +-Global / streamsManager = Task[sbt.std.Streams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |  | |   |
//        |  | |   +-Global / settingsData = Task[sbt.internal.util.Settings[sbt.Scope]]
//        |  | |   +-thisProjectRef = ProjectRef(file:/C:/Users/bnyu/Documents/IdeaProjects/exam/,exam)
//        |  | |   +-Global / trackInternalDependencies = TrackAlways
//        |  | |
//        |  | +-incOptions = Task[xsbti.compile.IncOptions]
//        |  |
//        |  +-Global / enableBinaryCompileAnalysis = true
//        |  +-Compile / manipulateBytecode = Task[xsbti.compile.CompileResult]
//        |    +-Compile / compileIncremental = Task[xsbti.compile.CompileResult]
//        |      +-Compile / compile / compileInputs = Task[xsbti.compile.Inputs]
//        |      | +-Compile / compileIncSetup = Task[xsbti.compile.Setup]
//        |      | +-Compile / compile / compileOptions = Task[xsbti.compile.CompileOptions]
//        |      | | +-Compile / classDirectory = target\scala-2.12\classes
//        |      | | +-Global / compileOrder = Mixed
//        |      | | +-Compile / dependencyClasspath = Task[scala.collection.Seq[sbt.internal.util.Attributed[java.io.File]]]
//        |      | | +-Global / javacOptions = Task[scala.collection.Seq[java.lang.String]]
//        |      | | +-Global / maxErrors = 100
//        |      | | +-Compile / scalacOptions = Task[scala.collection.Seq[java.lang.String]]
//        |      | | +-Global / sourcePositionMappers = Task[scala.collection.Seq[scala.Function1[xsbti.Position, scala.Option[xsbti.Position]]]]
//        |      | | +-Compile / sources = Task[scala.collection.Seq[java.io.File]]
//        |      | |
//        |      | +-compilers = Task[xsbti.compile.Compilers]
//        |      | +-Compile / previousCompile = Task[xsbti.compile.PreviousResult]
//        |      |
//        |      +-Compile / compileIncremental / streams = Task[sbt.std.TaskStreams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |        +-Global / streamsManager = Task[sbt.std.Streams[sbt.internal.util.Init$ScopedKey[_ <: Any]]]
//        |""".stripMargin
//
//    val root = TreeNodes.generateTreeNodes(input)
//    val output = TreeNodes.asciiDisplay(root).mkString("\r\n")
//    assert(input == output)
//  }
//
//  it should "have only one root" in {
//    val input =
//      """+-Global / skip = Task[Boolean]
//        |+-Compile / compileAnalysisFilename = Task[java.lang.String]
//        || +-Global / crossPaths = true
//        || +-scalaBinaryVersion = 2.12
//      """.stripMargin
//    val root = TreeNodes.generateTreeNodes(input)
//    val output = TreeNodes.asciiDisplay(root).mkString("\r\n")
//    assert(output ==
//      """+-Compile / compileAnalysisFilename = Task[java.lang.String]
//        |  +-Global / crossPaths = true
//        |  +-scalaBinaryVersion = 2.12
//        |""".stripMargin)
//  }
//
//}
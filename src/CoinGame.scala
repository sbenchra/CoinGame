import scala.util.Random
import scala.io.StdIn.readLine
import scala.annotation.tailrec
case class GameState(var nbFlips: Int = 0, var nbCorrectFlips: Int = 0)

object Main extends App {
    @tailrec
    def game(gamestate: GameState, random : Random): Unit={
      //var gameHistoric = new Array[GameState]() Not yet

      var nbFlips = gamestate.nbFlips
      var nbCorrectFlips = gamestate.nbCorrectFlips
      val input = readLine(" Select a Flip head(h), tail(t), quit(q) > ")
      val toss = random.nextInt() % 2
      input match {
        case "h" | "t"  =>
          nbFlips += 1
          if((input == "h" && toss ==0) || (input=="t" && toss==1)) {
            nbCorrectFlips += 1
            print("Successed \n")
          }
          else {
            print("Failed \n")
          }
         // gameHistoric.add(GameState(nbFlips, nbCorrectFlips)) Not yet
          game(GameState(nbFlips, nbCorrectFlips), random)

        case "q" =>
          print("Game Over \n")
          println("Plays : " + nbFlips)
          println ("Correct : " + nbCorrectFlips)
        case "n" =>
          print("Welcome again \n")
          game(GameState(), random)
      }
    }
  game(GameState(),new Random())

}
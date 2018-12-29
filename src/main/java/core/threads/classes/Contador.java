package core.threads.classes;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Contador {
	private int count;
	private AtomicInteger atomicInteger = new AtomicInteger();
	private AtomicInteger atomicIntegerWithExecutorService = new AtomicInteger();
	//private ExecutorService executor = Executors.newFixedThreadPool(2);
	
	
	public synchronized void incrementSynchronized() {
		count++;
	}
	
    //============================================================================
	//              Variaveis Atomicas - java.util.concurrent.atomic
	//============================================================================
	/*
	 Variaveis atomicas fazem uso de CAS (Compare And Swap)
	 Geralmente são muito mais rapidas
	 do que sincronizar por meio de bloqueios (synchronized)

	 Ao usar AtomicInteger como substituto Integer, podemos incrementar o número
	 simultaneamente em uma manobra thread-safe sem sincronizar o acesso à
	 variável. O método getAndIncrement()é uma operação atômica, portanto, podemos
	 chamar esse método com segurança de vários encadeamentos.

	 AtomicInteger suporta vários tipos de operações atômicas.
	 O método updateAndGet()aceita uma expressão lambda para executar
	 operações aritméticas arbitrárias no inteiro:
    */
	public void increment() {
		atomicInteger.getAndIncrement();
	}
    //============================================================================
	
	
	public int getCount() {
		return count;
	}

	public int getAtomicInteger() {
		return atomicInteger.get();
	}

	public int getAtomicIntegerWithExecutorService() {
		return atomicIntegerWithExecutorService.get();
	}

    //============================================================================
	//                      Atribuindo Tarefas ao ExecutorService
	//============================================================================
	/*
	 	ExecutorService pode executar tarefas Runnable e Callable.
	 	As tarefas podem ser atribuídas ao ExecutorService usando vários métodos: 
	 	execute () , que é herdado da interface do Executor , 
	 	submit ()  
	 	invokeAny ()
	 	invokeAll ()

		O método execute () é nulo e não dá qualquer possibilidade de obter o 
		resultado da execução da tarefa ou de verificar o status da tarefa 
		(ela está em execução ou executada).
		Ex.: executorService.execute(runnableTask);
		
		submit () envia umatarefa de Callable ou Runnable para um ExecutorService 
		e retorna um resultado do tipo Future .
		Ex.: Future<String> future =   executorService.submit(callableTask);
		
		invokeAny () atribui uma coleção de tarefas a um ExecutorService, 
		fazendo com que cada uma seja executada e retorna o resultado de uma execução 
		bem-sucedida de uma tarefa (se houve uma execução bem-sucedida) .
        ex.: String result = executorService.invokeAny(callableTasks);
        
		invokeAll () atribui uma coleção de tarefas a um ExecutorService, 
		fazendo com que cada uma seja executada e retorna o resultado de todas as execuções 
		de tarefas na forma de uma lista de objetos do tipo Futuro .
		Ex.: List<Future<String>> futures = executorService.invokeAll(callableTasks);
		 
	 */
	public void incrementWithExecutor( ExecutorService executor, int num) {
		atomicIntegerWithExecutorService.set(0);
		
		// codigo abaixo foi comentado para demonstrar p retorno do executor em um Future.
		// IntStream.range(0, num).forEach( i-> executor.submit(atomicIntegerWithExecutorService::getAndIncrement));
		
		//============================================================
		// 5. A interface do futuro
		/*
		Os métodos submit () e invokeAll () retornam um objeto ou uma coleção de objetos do tipo Future , 
		o que nos permite obter o resultado da execução de uma tarefa ou verificar o status da tarefa 
		(está em execução ou executado).
		A interface Future fornece um método de bloqueio especial get () 
		que retorna um resultado real da execução da tarefa Callable ou null 
		no caso da tarefa Runnable . Chamar o método get () enquanto a tarefa ainda está em execução 
		fará com que a execução seja bloqueada até que a tarefa seja executada corretamente 
		e o resultado esteja disponível.
		*/
		IntStream.range(0, num).forEach( i-> {
			Future<Integer> future = executor.submit(atomicIntegerWithExecutorService::getAndIncrement);
			
			try {
			   // System.out.println("future get: " + future.get());
			    System.out.println("future get: " + future.get(200, TimeUnit.MILLISECONDS));
			} catch ( ExecutionException | InterruptedException | TimeoutException e) {
			    e.printStackTrace();
			}
			
			
			
			//============================================================
			//============================================================
			/*
			 Com o bloqueio muito longo causado pelo método get () , 
			 o desempenho de um aplicativo pode degradar. Se os dados 
			 resultantes não forem cruciais, é possível evitar esse problema 
			 usando tempos limite:
             Ex.: Integer result = future.get(200, TimeUnit.MILLISECONDS);
             
             Se o período de execução for maior que o especificado (nesse caso, 200 milissegundos), 
             um TimeoutException será lançado.
             
             O método isDone () pode ser usado para verificar se a tarefa atribuída 
             já está sendo processada ou não.
             A interface Future também fornece o cancelamento da execução da tarefa 
             com o método cancel () , e para verificar o cancelamento com o 
             método isCancelled () :
             Ex.: boolean canceled = future.cancel(true);
				  boolean isCancelled = future.isCancelled();
			 */
		});

		System.out.println("dentro ExecutorService: " + atomicIntegerWithExecutorService.get()); // => 1000
		//stop( executor);

	}
	
    //============================================================================
	//                           Encerrando um ExecutorService
	//============================================================================
	/*
	 * 
	 * Em geral, o ExecutorService não será destruído automaticamente quando não
	 * houver tarefa para processar. Ele permanecerá vivo e aguardará novos
	 * trabalhos. 
	 * 
	 * Em alguns casos isso é muito útil; por exemplo, se um aplicativo
	 * precisar processar tarefas que aparecem de forma irregular ou a quantidade
	 * dessas tarefas não for conhecida em tempo de compilação. Por outro lado, um
	 * aplicativo pode chegar ao fim, mas não será interrompido porque um
	 * ExecutorService em espera fará com que a JVM continue em execução. 
	 * 
	 * Para encerrar corretamente um ExecutorService , temos as APIs shutdown () e
	 * shutdownNow () . O método shutdown () não causa uma destruição imediata do
	 * ExecutorService. Isso fará com que o ExecutorService pare de aceitar novas
	 * tarefas e desligue após todos os threads em execução concluírem seu trabalho
	 * atual. 
	 * 
	 * (1) executorService.shutdown(); 
	 * O método shutdownNow () tenta destruir o ExecutorService imediatamente, 
	 * mas não garante que todos os threads em execução sejam interrompidos ao mesmo tempo. 
	 * Este método retorna uma lista de tarefas que estão aguardando para serem processadas. 
	 * Cabe ao desenvolvedor decidir o que fazer com essas tarefas. 
	 * (1) List<Runnable> notExecutedTasks = executorService.shutDownNow();
	 * 
	 * Uma boa maneira de encerrar o ExecutorService (que também é recomendado pelo Oracle ) 
	 * é usar os dois métodos combinados com o método awaitTermination () . Com essa abordagem, 
	 * o ExecutorService primeiro parará de executar novas tarefas, a aguardar até um período 
	 * de tempo especificado para que todas as tarefas sejam concluídas. 
	 * Se esse tempo expirar, a execução será interrompida imediatamente:
	 */
	public void stop(ExecutorService executor) {
		
		executor.shutdown();
		try {
			if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
				System.out.println("Dentro do if do stop()");
				List<Runnable> notExecutedTasks = executor.shutdownNow();
				
				notExecutedTasks.forEach(t-> System.out.println("treads em empera: " + t + " - " + notExecutedTasks.size() ));
			}
		} catch (InterruptedException e) {
			System.out.println("Catch do executor.awaitTermination");
			executor.shutdownNow();
		}
	}
    //===========================================================================
	
	//===========================================================================
	//                             CONSIDERAÇÕES
	//===========================================================================
    /*
	 ExecutorService vs. Fork / Join
		Após o lançamento do Java 7, muitos desenvolvedores decidiram que a estrutura 
		ExecutorService deveria ser substituída pela estrutura fork / join. 
		Esta nem sempre é a decisão certa, no entanto. 
		Apesar da simplicidade de uso e dos ganhos frequentes de desempenho associados 
		ao fork / join,	há também uma redução na quantidade de controle do desenvolvedor 
		sobre a execução simultânea.
		
		O ExecutorService fornece ao desenvolvedor a capacidade de controlar o número de 
		encadeamentos gerados e a granularidade de tarefas que devem ser executadas por 
		encadeamentos separados. O melhor caso de uso para o ExecutorService é o processamento 
		de tarefas independentes, como transações ou solicitações, de acordo com o esquema 
		"um thread para uma tarefa".
		Em contraste, de acordo com a documentação da Oracle , o fork / join foi projetado 
		para acelerar o trabalho, que pode ser dividido em partes menores de forma recursiva.
     
	Conclusão:
		Mesmo apesar da relativa simplicidade do ExecutorService , existem algumas armadilhas comuns. 
		Vamos resumi-los:
			Mantendo um ExecutorService não utilizado ativo: Há uma explicação detalhada na seção 4 
			deste artigo sobre como encerrar um ExecutorService ;
			Capacidade errada do pool de encadeamentos ao usar pool de encadeamentos de comprimento fixo: 
			É muito importante determinar quantos encadeamentos o aplicativo precisará para executar 
			tarefas com eficiência. Um conjunto de encadeamentos que é muito grande causará sobrecarga 
			desnecessária apenas para criar encadeamentos que, na maioria das vezes, estarão no modo de 
			espera. Muito poucos podem fazer com que um aplicativo pareça não responder devido a longos 
			períodos de espera por tarefas na fila;
			Chamar um Futuro 's get () método após o cancelamento tarefa: Uma tentativa de obter o resultado 
			de uma tarefa já cancelada irá desencadear uma CancellationException.
			Bloqueio inesperadamente longo com o método get () da Future : Os tempos limite devem ser usados 
			​​para evitar esperas inesperadas.    
     
     */
	//===========================================================================
	//===========================================================================
	
}

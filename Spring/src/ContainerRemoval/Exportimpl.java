package ContainerRemoval;


import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class Exportimpl extends DelegatingIntroductionInterceptor implements Export{

	@Override
	public void doExport() {
		// TODO Auto-generated method stub
		System.out.println("Do export method is called.....");
	}
}

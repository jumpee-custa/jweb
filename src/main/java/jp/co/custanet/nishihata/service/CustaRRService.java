package jp.co.custanet.nishihata.service; 
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.RetrieveAndRank;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterOptions;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster.Status;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusters;

public class CustaRRService {
	private final String RR_PASSWORD = "JlnfpQXoZGHp";
	private final String RR_USER = "e573a5c0-dc43-4322-a9d7-26859dcf8251";

	RetrieveAndRank service = new RetrieveAndRank();
	
	public void login() {
		// TODO 自動生成されたメソッド・スタブ
		service.setUsernameAndPassword(RR_USER,RR_PASSWORD);
	}
	public SolrClusters list(){
			SolrClusters solrClusters = service.getSolrClusters().execute();
			return solrClusters;
		} 

	public void createSolr(String clusterName)  {
		// 1 create the Solr Cluster
		SolrClusterOptions options = new SolrClusterOptions(clusterName, 1);
		SolrCluster cluster = service.createSolrCluster(options).execute();
		System.out.println("Solr cluster: " + cluster);
		
		// 2 wait until the Solr Cluster is available
		while (cluster.getStatus() == Status.NOT_AVAILABLE) {
		  try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return;
		} // sleep 10 seconds
		  cluster = service.getSolrCluster(cluster.getId()).execute();
		  System.out.println("Solr cluster status: " + cluster.getStatus());
		}

		// 3 list Solr Clusters
		System.out.println("Solr clusters: " + service.getSolrClusters().execute());
	}
}

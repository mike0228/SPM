package cn.edu.njust.dev.ses.main.model;

public class GradesEntryProof {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column grades_entry_proof.gid
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    private Integer gid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column grades_entry_proof.proof_url
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    private String proofUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column grades_entry_proof.gid
     *
     * @return the value of grades_entry_proof.gid
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column grades_entry_proof.gid
     *
     * @param gid the value for grades_entry_proof.gid
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column grades_entry_proof.proof_url
     *
     * @return the value of grades_entry_proof.proof_url
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    public String getProofUrl() {
        return proofUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column grades_entry_proof.proof_url
     *
     * @param proofUrl the value for grades_entry_proof.proof_url
     *
     * @mbg.generated Fri Dec 20 21:52:51 CST 2019
     */
    public void setProofUrl(String proofUrl) {
        this.proofUrl = proofUrl == null ? null : proofUrl.trim();
    }
}
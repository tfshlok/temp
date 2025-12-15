## Unit 1 – Introduction to Cloud Computing

### 1.1 Evolution of Computing → Cloud

1. **Mainframe and time‑sharing**
   - Central mainframe shared by many users via terminals.
   - Expensive hardware; limited flexibility.

2. **Client–Server computing**
   - Powerful servers + many client PCs.
   - Applications split into front‑end (UI) and back‑end (DB, logic).

3. **Distributed, grid and cluster computing**
   - Multiple networked machines cooperate on a single task.
   - Used for scientific simulations, rendering, large batch jobs.

4. **Utility / on‑demand computing**
   - Computing resources offered like public utilities.
   - Pay for what you consume instead of owning hardware.

5. **Cloud computing era**
   - Internet + virtualization + cheap hardware.
   - Third‑party cloud providers build massive data centres and sell computing as a **service**.
   - Users see virtual resources (VMs, storage, DBs) instead of physical servers.

---

### 1.2 What Is Cloud Computing?

> Cloud computing is a model for enabling convenient, on‑demand network access to a shared pool of configurable computing resources (servers, storage, networks, applications, services) that can be rapidly provisioned and released with minimal management effort.

Key points:

- Services delivered over the **internet**.
- Provider owns and manages infrastructure.
- Customer pays as per **usage** (OpEx model).

---

### 1.3 Essential Characteristics

1. **On‑Demand Self‑Service**
   - Users can provision resources (VMs, storage, DBs) automatically via portal or API.
   - No human interaction with provider is needed.

2. **Broad Network Access**
   - Services accessible over standard networks and protocols (e.g., HTTP/HTTPS).
   - Supports heterogeneous clients: laptops, mobiles, thin clients.

3. **Resource Pooling and Multi‑Tenancy**
   - Provider’s resources are pooled to serve multiple customers.
   - Same physical servers are shared, but each tenant’s data is isolated logically.

4. **Rapid Elasticity**
   - Resources can be scaled up/down quickly according to load.
   - Applications can grow to handle spikes and shrink to save cost (cloud bursting).

5. **Measured Service**
   - Usage is monitored, controlled and reported (CPU hours, GB‑months, requests).
   - Enables **pay‑as‑you‑go** billing.

---

### 1.4 Service Models – IaaS, PaaS, SaaS

#### 1.4.1 Infrastructure as a Service (IaaS)

- Provides **fundamental computing resources**:
  - Virtual machines, CPUs, memory.
  - Block and object storage.
  - Virtual networks, firewalls, load balancers.
- Consumer manages:
  - OS, middleware, runtime, applications and data.
- Examples:
  - AWS EC2, Amazon EBS, S3 (as raw storage).
  - Google Compute Engine, Azure Virtual Machines.

Use‑cases:

- Custom application stacks.
- Lift‑and‑shift migration from on‑premise servers.
- Full control over OS and runtime.

---

#### 1.4.2 Platform as a Service (PaaS)

- Provides **platform** for building, running and managing applications.
- Includes:
  - OS, runtime, programming language support.
  - Managed databases and middleware.
  - Developer tools, CI/CD pipelines.
- Consumer manages only:
  - Application code and data.
- Examples:
  - Google App Engine, AWS Elastic Beanstalk, Azure App Service, Heroku.

Benefits:

- Faster development and deployment.
- Automatic scaling and patching.
- Developers focus on business logic, not infrastructure.

---

#### 1.4.3 Software as a Service (SaaS)

- Delivers **complete applications** over the internet.
- Everything (infrastructure + platform + app) is managed by provider.
- User interacts via browser or thin client.

Examples:

- Gmail, Outlook.com
- Microsoft 365, Google Workspace
- Salesforce CRM, Dropbox

Properties:

- Subscription or pay‑per‑use pricing.
- Zero installation and maintenance for end user.

---

#### 1.4.4 IaaS vs PaaS vs SaaS – Quick Table

| Aspect       | IaaS                             | PaaS                                  | SaaS                             |
|-------------|----------------------------------|---------------------------------------|----------------------------------|
| Control     | User controls OS → app          | User controls app & data only         | User controls config & data only |
| Provider    | Hardware + virtualization        | Hardware + OS + runtime + DB          | Full stack incl. application     |
| Users       | Sysadmins, DevOps, infra teams  | Developers                            | End users                        |
| Examples    | EC2, GCE, Azure VM              | GAE, Elastic Beanstalk, Azure AppSvc  | Gmail, Office 365, Salesforce    |

---

### 1.5 Deployment Models

1. **Public Cloud**
   - Infrastructure owned by third‑party providers.
   - Resources shared across many customers.
   - Pros: low cost, high scalability, no infra management.
   - Cons: less control, data locality/security concerns.

2. **Private Cloud**
   - Cloud environment dedicated to a single organisation.
   - Implemented on‑premises or in hosted data centre.
   - Pros: higher control, custom security & compliance.
   - Cons: higher cost and management effort.

3. **Hybrid Cloud**
   - Combines public and private clouds.
   - Data/applications can move between them.
   - Supports **cloud bursting**: normal workload runs on private cloud, spikes go to public cloud.

4. **Community Cloud**
   - Shared by several organisations with similar needs (e.g., universities, government bodies).
   - Costs and governance shared among community members.

---

### 1.6 Cloud Computing Architecture (Logical View)

Typical layered view:

1. **Client Layer**
   - End‑user devices: browsers, mobile apps, thin clients.

2. **Application Layer (SaaS)**
   - Cloud‑hosted applications: email, CRM, office tools.

3. **Platform Layer (PaaS)**
   - Runtimes, frameworks, databases, middleware.

4. **Infrastructure Layer (IaaS)**
   - Compute, storage and networking abstractions (VMs, volumes, virtual networks).

5. **Virtualization Layer**
   - Hypervisors (KVM, VMware, Hyper‑V), containers (Docker).
   - Responsible for resource pooling and isolation.

6. **Physical Resource Layer**
   - Actual hardware: servers, storage arrays, networking gear, power and cooling.

7. **Management & Security Layer**
   - Monitoring, billing, orchestration, identity and access management, logging, policy enforcement.

---

### 1.7 Key Concepts Related to Cloud

1. **Multitenancy**
   - Single application instance or infrastructure serves multiple customers (tenants).
   - Each tenant’s data and configuration are logically isolated.
   - Benefits: high utilization, cost sharing.
   - Challenges: data isolation, performance interference (“noisy neighbour”).

2. **Scalability**
   - Ability to handle growing workload by adding resources.
   - Types:
     - Vertical (scale‑up): add more CPU/RAM to same machine.
     - Horizontal (scale‑out): add more machines/instances.

3. **Elasticity**
   - Automatic and rapid scaling based on real‑time demand.
   - Key for handling unpredictable traffic patterns.

4. **Cloud Bursting**
   - Application primarily runs in private cloud or data centre.
   - When load spikes beyond local capacity, extra load “bursts” into public cloud.

---

### 1.8 Advantages and Disadvantages of Cloud Computing

#### Advantages

- **Cost Efficiency**
  - No large upfront hardware investment.
  - Pay‑as‑you‑go and reserved pricing options.

- **Global Reach & Availability**
  - Data centres in multiple regions for low latency and redundancy.

- **Speed & Agility**
  - Quick provisioning of infrastructure in minutes instead of weeks.

- **Reliability and Disaster Recovery**
  - Built‑in redundancy, automated backups, cross‑region replication.

- **Managed Services**
  - Databases, analytics, AI, messaging, monitoring, etc., provided as services.

#### Disadvantages / Challenges

- **Security and Privacy Concerns**
  - Data stored off‑premises; risk of breaches and misconfigurations.

- **Vendor Lock‑in**
  - Hard to migrate applications from one provider to another.

- **Downtime and Service Outages**
  - Outages at provider impact all customers relying on that region/service.

- **Network Dependence & Latency**
  - Performance linked to quality of internet connection.

- **Compliance and Legal Issues**
  - Data residency, regulatory requirements differ across countries.

---

### 1.9 Typical Cloud Applications (Exam Favourites)

- **Data Storage & Backup** – Google Drive, Dropbox, Amazon S3.
- **Email Services** – Gmail, Outlook, Yahoo.
- **Business Apps / SaaS** – Salesforce, Office 365, Google Workspace.
- **Software Development & Testing** – On‑demand build servers, test environments.
- **Streaming & Content Delivery** – Netflix, YouTube, music streaming.
- **Education & Healthcare** – LMS platforms, virtual labs, telemedicine.

---

## Unit 2 – Abstraction and Virtualization

### 2.1 Introduction to Virtualization

- **Virtualization** = technique of creating a virtual (rather than physical) version of something:
  - Operating system, server, storage device, or network resources.
- Main goals:
  - Improve resource utilization (consolidate workloads).
  - Provide isolation between tenants.
  - Make provisioning, backup, and migration easier.

---

### 2.2 Virtualization Technologies and Cloud‑Enabling Technologies

Key technologies enabling cloud:

1. **Server Virtualization**
   - Hypervisors create multiple virtual machines (VMs) on one physical server.
   - Each VM runs its own OS and applications.

2. **Containerization**
   - OS‑level virtualization where applications run in isolated containers sharing host kernel.
   - Docker, LXC, containerd.

3. **Orchestration Platforms**
   - Tools like Kubernetes, OpenShift that schedule and manage containers across clusters.

4. **Distributed / Virtualized Storage**
   - Systems like HDFS, Ceph, Amazon S3, Elastic Block Store.
   - Abstract multiple disks and servers as a single storage pool.

5. **Software‑Defined Networking (SDN)**
   - Decouples control plane from data plane.
   - Allows programmable virtual networks, security groups and overlays.

6. **Automation & Infrastructure as Code**
   - Tools such as Terraform, Ansible, Chef, CloudFormation automate provisioning.

7. **Middleware & Web Services (SOA / REST APIs)**
   - Enable integration between services across networks.

---

### 2.3 Types of Virtualization

1. **Server Virtualization**
   - Multiple VMs on a single physical server.
   - Provides isolation, consolidation and ease of management.

2. **Storage Virtualization**
   - Abstracts multiple physical storage devices into a unified storage pool.
   - Types: block‑level, file‑level, object‑level.

3. **Network Virtualization**
   - Creates logical networks (VLANs, virtual switches, VXLAN overlays) on top of physical network.
   - Facilitates multi‑tenant isolation and dynamic network provisioning.

4. **Desktop Virtualization**
   - User desktops run in VMs in data centre; users connect via thin client or RDP.

5. **Application Virtualization**
   - Application runs in a sandbox without full installation on host OS.

6. **OS‑Level Virtualization (Containers)**
   - Isolation at process level using namespaces and cgroups.
   - Lightweight and fast start‑up; multiple containers share same kernel.

---

### 2.4 Hypervisors and their Types

**Hypervisor / Virtual Machine Monitor (VMM)**

- Layer of software that allows multiple operating systems to run concurrently on a host computer by **abstracting and sharing hardware resources**.

#### Type‑1 Hypervisor (Bare‑Metal)

- Installed directly on the physical hardware.
- Guest operating systems run on top of hypervisor.
- Examples: VMware ESXi, Microsoft Hyper‑V, Xen, KVM.
- Advantages:
  - High performance & efficiency.
  - Better isolation and security.
  - Used in production data centres and clouds.

#### Type‑2 Hypervisor (Hosted)

- Runs as an application on a host operating system (Windows, Linux, macOS).
- Guest OS runs above the hypervisor app.
- Examples: Oracle VirtualBox, VMware Workstation, Parallels Desktop.
- Advantages:
  - Easy to install and use for development and testing.
- Disadvantages:
  - Lower performance because of extra host OS layer.

---

### 2.5 Virtual Machine Life‑Cycle and Provisioning

**Provisioning** = process of creating and configuring a new VM.

Typical life‑cycle steps:

1. **Template / Image Selection**
   - Choose base image (e.g., AMI in AWS) with OS and pre‑installed software.

2. **Resource Allocation**
   - Define vCPU, RAM, storage size & type, network configuration, security groups.

3. **Instantiation**
   - Hypervisor allocates resources and boots the VM.

4. **Configuration**
   - Run initialization scripts, install additional packages, configure users and services.

5. **Operation & Management**
   - Monitor performance, patch OS, take snapshots, scale up/down, attach/detach volumes.

6. **De‑provisioning / Termination**
   - Shut down and delete VM, free the resources, optionally archive snapshots.

Provisioning styles:

- **Manual** – admin creates each VM step by step.
- **Automated** – scripted or template‑based creation using tools.
- **Self‑Service** – end‑users request VMs via a portal and automation handles provisioning.
- **Hybrid** – combination of above according to policy.

---

### 2.6 Physical Cluster vs Virtual Cluster

**Physical Cluster**

- Group of interconnected physical servers working together as a single system.
- Nodes are fixed hardware; scaling requires buying and installing new servers.
- Used traditionally for HPC and large database workloads.

**Virtual Cluster**

- Cluster built using **virtual machines** instead of purely physical nodes.
- VMs may reside on multiple physical hosts and can be dynamically created or destroyed.
- Enables:
  - Better resource utilization.
  - Easier scaling and management.
  - Integration with cloud auto‑scaling.

| Feature        | Physical Cluster                      | Virtual Cluster                               |
|---------------|----------------------------------------|-----------------------------------------------|
| Node type     | Dedicated physical machines            | Virtual machines on shared hardware           |
| Flexibility   | Low, hardware‑bound                    | High – VMs can be created/migrated quickly    |
| Scalability   | Limited by available hardware          | Elastic, can use cloud resources              |
| Cost          | High CapEx and power/cooling           | Lower by consolidating many VMs per host      |
| Management    | Manual hardware maintenance            | Managed via hypervisors and cloud platforms   |

---

### 2.7 Virtual Machine Migration

- **VM migration** = moving a VM from one physical host to another.

Types:

1. **Cold Migration**
   - VM is powered off, then moved, then powered on.
   - Simple but involves noticeable downtime.

2. **Live Migration**
   - VM keeps running while its memory and state are copied to the destination host.
   - Short pause during final switchover; nearly zero downtime.

Reasons to migrate:

- Load balancing across hosts.
- Hardware maintenance without application downtime.
- Power saving (consolidate VMs to fewer servers).
- Fault tolerance and disaster recovery.

---

### 2.8 Virtualization of CPU, Memory and I/O (Conceptual Overview)

1. **CPU Virtualization**
   - Hypervisor schedules virtual CPUs (vCPUs) of VMs onto physical CPU cores.
   - Hardware support (Intel VT‑x, AMD‑V) allows guests to run privileged instructions efficiently.
   - Time‑sharing ensures each VM gets CPU slices.

2. **Memory Virtualization**
   - Each VM believes it has contiguous physical memory.
   - Hypervisor maintains mappings from guest physical pages to host physical frames.
   - Techniques:
     - Shadow page tables / nested page tables.
     - Ballooning and overcommit to share unused memory.

3. **I/O Virtualization**
   - Virtual devices (virtual NICs, disks) presented to each VM.
   - Hypervisor multiplexes physical devices among VMs.
   - Paravirtual drivers or SR‑IOV improve performance.

---

### 2.9 Load Balancing and Virtualization

- **Load balancing** = distributing incoming requests across multiple servers or VMs to avoid overload and ensure high availability.
- Common algorithms:
  - **Round Robin** – send each request to next server in sequence.
  - **Weighted Round Robin** – heavier‑capacity servers get higher weight.
  - **Least Connections** – choose server with fewest active connections.
- Works closely with virtualization:
  - New VMs can be provisioned when load increases.
  - Load balancer automatically includes new instances in rotation.

---

### 2.10 Cloud‑Enabling vs Cloud‑Enabled

- **Cloud‑enabling technologies**
  - Technologies like virtualization, SDN, distributed storage, orchestration and automation that make cloud possible.

- **Cloud‑enabled applications**
  - Applications designed or refactored to use cloud features:
    - Stateless web tiers, externalized session storage.
    - Use of managed DBs, caches and messaging.
    - Horizontal scaling and auto‑scaling.

---

## Unit 3 – Overview of Cloud Security

### 3.1 Introduction to Cloud Security

- Cloud security = policies, controls, procedures and technologies that protect cloud data, applications and infrastructure.
- Goals follow **CIA triad**:
  - **Confidentiality** – prevent unauthorized disclosure of data.
  - **Integrity** – prevent unauthorized modification of data.
  - **Availability** – ensure authorised users can access services when needed.

Security responsibilities:

- **Cloud provider** – physical security, infrastructure, virtualization, core services.
- **Customer** – data classification, identity & access, app security, configurations (“shared responsibility model”).

---

### 3.2 Cloud Security Challenges and Risks

Common risks in cloud environments:

1. **Data Breaches**
   - Attackers access sensitive information due to weak access controls or vulnerabilities.

2. **Data Loss**
   - Data accidentally deleted, corrupted, or lost due to failures or attacks if no proper backup.

3. **Insecure APIs & Interfaces**
   - Cloud services are controlled via APIs; poor design or misconfigured keys can allow unauthorised access.

4. **Account Hijacking**
   - Stolen credentials (phishing, key leaks) let attacker control cloud resources.

5. **Insider Threats**
   - Malicious or careless employees of provider or customer organisation.

6. **Lack of Compliance / Legal Issues**
   - Failure to meet regulations (GDPR, HIPAA) can cause penalties.

7. **Multi‑Tenancy Risks**
   - Data leakage or side‑channel attacks between tenants if isolation fails.

---

### 3.3 Cloud Security Architecture Design (High‑Level)

A good security architecture includes:

1. **Identity and Access Management (IAM)**
   - Centralised control of who can access which resource with which permissions.
   - Uses roles, policies, groups and least‑privilege principle.

2. **Network Security**
   - Virtual networks (VPC, VNet), subnets.
   - Security groups / network security groups (NSG) as stateful firewalls.
   - VPNs and private links for secure connectivity.

3. **Data Protection**
   - Encryption **at rest** (disk, DB, backups) and **in transit** (TLS/SSL).
   - Key management services (KMS, Key Vault).

4. **Application Security**
   - Secure coding practices, input validation, patching.
   - Web Application Firewalls (WAF).

5. **Monitoring and Logging**
   - Central log collection (CloudWatch, Azure Monitor).
   - Intrusion detection systems, SIEM tools.

6. **Backup and Disaster Recovery**
   - Regular backups, replication across regions.
   - Tested recovery plans and RTO/RPO objectives.

---

### 3.4 Identity Management and Access Control (IAM)

**Identity Management (IdM)**

- Process of creating, managing and deleting digital identities (users, groups, service accounts).
- Supports single sign‑on (SSO), password policies, MFA.

**Access Control**

- Mechanism deciding who can access what.
- Common models:
  - **DAC** – Discretionary Access Control: owner decides permissions.
  - **MAC** – Mandatory Access Control: central authority enforces policies.
  - **RBAC** – Role‑Based Access Control: permissions grouped into roles like Admin, Auditor, Developer.

**IAM Features**

- User and group management.
- Roles and attached policies.
- Authentication methods: passwords, MFA, keys, certificates.
- Auditing and access logs.

---

### 3.5 Multi‑Factor Authentication (MFA)

- Requires at least **two different factors** to log in:
  1. Something you know – password, PIN.
  2. Something you have – OTP token, phone, smart card.
  3. Something you are – fingerprint, face recognition.

Benefits:

- Reduces risk of account hijacking.
- Even if password is stolen, attacker still needs second factor.

---

### 3.6 Cloud Security Monitoring

**Security Monitoring** = continuous observation of cloud resources and activities to detect threats.

Benefits:

1. Real‑time threat detection (alerts for anomalies).
2. Centralised visibility in multi‑account, multi‑region setup.
3. Helps maintain compliance and generate audit reports.
4. Supports quick incident response.

Challenges:

1. Complexity of multi‑cloud and hybrid environments.
2. Large volume of logs → many false positives.
3. Integration between different provider tools.
4. Privacy considerations when analysing user data.

Typical tools:

- AWS CloudWatch, GuardDuty, CloudTrail.
- Azure Monitor, Security Center.
- GCP Cloud Logging, Security Command Center.
- SIEM products (Splunk, ELK, etc.).

---

### 3.7 Disaster Recovery in Clouds

**Disaster Recovery (DR)** = ability to restore IT services after disasters (hardware failure, natural events, cyber‑attacks).

Key concepts:

- **Backup and replication**
  - Regular backups; cross‑region or cross‑zone replication.
- **Failover and failback**
  - Automatic or manual switch to standby systems; return to primary when fixed.
- **RTO (Recovery Time Objective)**
  - Maximum acceptable downtime (e.g., 1 hour).
- **RPO (Recovery Point Objective)**
  - Maximum acceptable data loss measured in time (e.g., 15 minutes).

Cloud DR advantages:

- Cheaper than maintaining secondary physical data centre.
- Easier testing of DR plans using snapshots, templates and automation.

---

### 3.8 Cloud Security in Service Models

- **IaaS**
  - Customer secures OS, applications, data, network security groups.
- **PaaS**
  - Provider secures platform; customer focuses on app and data (SQL injection, access control).
- **SaaS**
  - Provider secures entire stack; customer manages users, roles, and data sharing.

---

## Unit 4 – Cloud Technologies and Advancements

### 4.1 Cloud Platforms for Large‑Scale Computing

Major providers:

- **Amazon Web Services (AWS)**
- **Microsoft Azure**
- **Google Cloud Platform (GCP)**
- Others: IBM Cloud, Alibaba Cloud, OpenStack‑based private clouds.

Cloud platforms provide:

- Compute (VMs, serverless, containers).
- Storage (object, block, file).
- Databases, analytics, AI/ML, IoT.
- Developer tools, monitoring and security services.

---

### 4.2 Amazon Web Services – Core Services

1. **Compute**
   - **EC2** – Elastic Compute Cloud: resizable virtual servers.
   - **Lambda** – serverless functions triggered by events.
   - **ECS/EKS** – container orchestration (Docker/Kubernetes).

2. **Storage**
   - **S3 (Simple Storage Service)** – scalable object storage.
   - **EBS (Elastic Block Store)** – block storage for EC2.
   - **EFS (Elastic File System)** – managed NFS file storage.
   - **FSx** – Windows file server / Lustre.
   - **S3 Glacier / Deep Archive** – long‑term archival storage.

3. **Databases**
   - **RDS** – managed relational DB (MySQL, PostgreSQL, etc.).
   - **DynamoDB** – NoSQL key‑value store.
   - **Aurora**, **Redshift** for analytics.

4. **Networking**
   - **VPC** – Virtual Private Cloud (isolated network).
   - **Elastic Load Balancer**, **Route 53** DNS.
   - VPN and Direct Connect for hybrid connectivity.

5. **Security & Management**
   - **IAM**, **CloudTrail**, **CloudWatch**, **GuardDuty**.

6. **AWS Clients**
   - AWS Management Console (web UI).
   - AWS CLI.
   - SDKs (Boto3 for Python, Java SDK, etc.).

---

### 4.3 Amazon S3 – Object Storage (Short Note)

- Stores objects (data + metadata) in **buckets**.
- Key features:
  - Virtually unlimited scalability.
  - High durability (e.g., 11 nines) via replication across availability zones.
  - Multiple storage classes:
    - Standard, Standard‑IA, Intelligent‑Tiering,
    - Glacier, Glacier Deep Archive.
  - Security:
    - Bucket policies, ACLs, IAM roles.
    - Server‑side and client‑side encryption.
  - Lifecycle rules for automatic transition and deletion.

Use‑cases:

- Backup and restore, big‑data lake, static website hosting, media content.

---

### 4.4 Microsoft Azure – Important Components

1. **Compute**
   - Azure Virtual Machines.
   - App Service (web apps, APIs).
   - Azure Functions (serverless).

2. **Storage**
   - Blob Storage (object).
   - Queue, Table, and File Storage.

3. **Networking**
   - Virtual Network (VNet), Load Balancer.
   - VPN Gateway, Application Gateway, Azure DNS.

4. **Databases**
   - Azure SQL Database, Cosmos DB (global NoSQL).
   - Managed MySQL/PostgreSQL.

5. **Security**
   - Azure Active Directory (identity).
   - Key Vault (secrets management).
   - Security Center, Defender for Cloud.

6. **Management & Dev Tools**
   - Azure Monitor, Log Analytics.
   - Azure DevOps, ARM templates, Bicep.

**Programming on Azure**

- Supports languages: C#, Java, Python, Node.js, etc.
- SDKs and REST APIs for all services.
- Visual Studio / VS Code integration for build, deploy and CI/CD.

---

### 4.5 Google App Engine & Google Cloud

**Google App Engine (GAE)** – PaaS for deploying web applications.

- Supports languages: Python, Java, Go, PHP, Node.js (standard & flexible environments).
- Features:
  - Automatic scaling of instances.
  - Integrated services: Datastore / Firestore, Cloud SQL, Task Queues, Memcache.
  - Built‑in security, logging, monitoring.
- Developer focuses on app code; Google handles OS, scaling and patching.

Google Cloud also provides:

- Compute Engine (VMs).
- Cloud Storage (object store).
- BigQuery (analytics), Pub/Sub (messaging), Cloud Functions (serverless).

---

### 4.6 Cloud Enabling Technologies (Revisited)

Cloud relies on:

- **Virtualization** – hypervisors, containers.
- **Broadband Networks** – high‑speed internet connectivity.
- **Web Services / SOA** – communication between distributed components.
- **Utility Computing** – metered resource usage.
- **Grid and Cluster Computing** – distributed processing foundations.

These technologies together allow the elastic, on‑demand model of cloud computing.

---

### 4.7 Hypervisors in Cloud Computing (Recap)

- Hypervisor manages multiple VMs on a single physical server.

Types:

1. **Type‑1 (Bare‑Metal)** – ESXi, Hyper‑V, Xen.
2. **Type‑2 (Hosted)** – VirtualBox, VMware Workstation.

Roles in cloud:

- Provide CPU, memory and I/O isolation between tenants.
- Enable features like snapshot, cloning, live migration.

---

### 4.8 Virtual Machine Provisioning and Manageability

**VM Provisioning**

- Creating and configuring VMs from templates or images.
- Steps:
  1. Select template (AMI, image).
  2. Choose instance type (size), storage, VPC/subnet.
  3. Configure security groups, key pairs.
  4. Launch VM and run bootstrapping scripts.

**Manageability**

- Monitoring CPU, memory, disk and network.
- Scaling groups or auto‑scaling policies.
- Applying patches and updates.
- Snapshotting and backup of volumes.
- VM migration for load balancing and maintenance.

---

### 4.9 Virtual Machine Migration – Techniques

- **Cold migration**
  - Stop VM, move its disk image, start on another host.

- **Live migration**
  - Perform state transfer while VM is running; short pause during switchover.

- **Storage migration**
  - Move VM’s storage (disk) to new datastore.

Benefits:

- Balances load, avoids hotspots.
- Enables maintenance without downtime.
- Supports disaster recovery scenarios.

---

### 4.10 Cloud Migration – Moving Applications to Cloud

Typical steps when migrating an existing application:

1. **Assessment**
   - Analyse current architecture, dependencies, performance and security requirements.
   - Decide which apps/components are suitable for cloud.

2. **Planning**
   - Choose migration strategy:
     - Rehost (lift‑and‑shift).
     - Refactor (modify for cloud).
     - Replatform, Rebuild or Replace (SaaS).
   - Select provider(s) and target services.

3. **Migration & Deployment**
   - Move data (databases, files) using migration tools.
   - Deploy app components on chosen IaaS/PaaS services.
   - Configure networking, IAM, monitoring and backup.

4. **Testing & Optimization**
   - Validate functionality, performance, and security.
   - Configure auto‑scaling, right‑size instances.
   - Optimise cost using reserved instances, storage classes.

---

### 4.11 Cloud Computing vs Grid Computing (Difference Points)

| Feature          | Cloud Computing                                  | Grid Computing                                         |
|-----------------|---------------------------------------------------|--------------------------------------------------------|
| Purpose         | On‑demand services for general workloads          | Distributed processing for large scientific tasks      |
| Resource Mgmt   | Centralised by provider                           | Decentralised across participating nodes               |
| Access          | Over internet using standard APIs                 | Often within research or organisational networks       |
| Scalability     | Highly elastic and automated                      | Limited by added nodes and scheduling                  |
| Cost Model      | Pay‑per‑use from provider                         | Often collaborative / shared, not strictly metered     |

---

### 4.12 Need for Cloud Computing (Why Organisations Adopt It)

- Reduce capital expenditure on hardware and data centres.
- Achieve global reach with low latency for users worldwide.
- Improve business agility (faster time‑to‑market).
- Support innovation with AI/ML, analytics, IoT services.
- Enable strong disaster recovery and backup.

---
